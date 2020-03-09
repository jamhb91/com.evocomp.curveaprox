/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evocomp.curveaprox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jamhb
 */
public class CurveFinder {
    private int equationSize = 0;
    private int generationSize = 0;
    private static final int NUMBER_OF_FUNCTIONS = Function.values().length;
    private static final int NUMBER_OF_OPERATORS = 1; //1 only sum, 2 sum and multiplication
    private static final int MATCH_SIZE = 5;
    private static final double [] GOALS = {62.6,67.1,64.6,61.0,62.8,61.1,61.8,63.2,62.8,58.6,58.7,57.6,55.8};
    
    public CurveFinder(int equationSize, int generationSize){
        this.equationSize = equationSize;
        this.generationSize = generationSize;
    }
    
    public List<EquationChromosome> createMatrix () throws Exception{
        List<EquationChromosome> matrix = new ArrayList<>();
        for(int i=0;i<generationSize;i++){
            matrix.add(createRandomChild(equationSize));
        }
        return matrix;
    }
    
    private EquationChromosome createRandomChild(int size) throws Exception{
        PolinomialElement [] chromosome = new PolinomialElement[size];
        Random r = new Random();
        
        for(int i=0; i<size; i++){
            chromosome[i] = new PolinomialElement(
                    r.nextDouble()*10,
                    r.nextInt(NUMBER_OF_FUNCTIONS),
                    r.nextInt(NUMBER_OF_OPERATORS)
            );
        }
        
        return new EquationChromosome(chromosome,calculateAptitude(chromosome));
    }
    
    private double calculateAptitude(PolinomialElement [] chromosome) throws Exception{
        double deltaSum = 0;
        for (int i = 0; i < GOALS.length; i++) {
            double calc=0;
            for (PolinomialElement polinomialElement : chromosome) {
                switch(polinomialElement.getOperator()){
                    case 0:
                        calc = calc + getFunctionCalculation(polinomialElement,i);
                        break;
                    case 1:
                        calc = calc * getFunctionCalculation(polinomialElement,i);
                        break;
                    default:
                        calc = calc + getFunctionCalculation(polinomialElement,i);
                        break;
                }
            }
            deltaSum = deltaSum + Math.abs(Math.max(GOALS[i], calc) - Math.min(GOALS[i], calc));
        }
        return deltaSum;
    }
    
    private double getFunctionCalculation(PolinomialElement element, double value) throws Exception{
        double elementCalc = 0;
        switch(Function.values()[element.getFunction()]){
            case COS:
                elementCalc = element.getConstant() * Math.cos(value);
                break;
            case SIN:
                elementCalc = element.getConstant() * Math.sin(value);
                break;
            case TAN:
                elementCalc = element.getConstant() * Math.tan(value);
                break;
            case EXP:
                elementCalc = element.getConstant() * Math.exp(value);
                break;
            case POW:
                elementCalc = Math.pow(value, element.getConstant());
                break;
            case SQRT:
                elementCalc = element.getConstant() * Math.sqrt(value);
                break;
            case LOG:
                elementCalc = element.getConstant() * Math.log(value);
                break;
            case LOG10:
                elementCalc = element.getConstant() * Math.log10(value);
                break;
            case NOFUNC:
                elementCalc = element.getConstant() * value;
                break;
            case ZERO:
                break;
            default:
                throw new Exception("Function not recognized");
        }
        return elementCalc;
    }
}
