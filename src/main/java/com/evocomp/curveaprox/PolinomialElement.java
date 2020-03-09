/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evocomp.curveaprox;

/**
 *
 * @author jamhb
 */
public class PolinomialElement {
    private double constant;
    private int function;
    private int operator;
    
    /***
     * Constructs a new object
     * @param constant constant value of the polinomial element
     * @param function integer representing the function to be used
     * @param operator operator to apply to the next element
     */
    public PolinomialElement(double constant, int function, int operator){
        this.constant = constant;
        this.function = function;
        this.operator = operator;
    }
    
    /**
     * @return the constant
     */
    public double getConstant() {
        return constant;
    }
    
    /**
     * @param constant the constant to set
     */
    public void setConstant(double constant) {
        this.constant = constant;
    }

    /**
     * @return the function
     */
    public int getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(int function) {
        this.function = function;
    }

    /**
     * @return the operator
     */
    public int getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(int operator) {
        this.operator = operator;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", this.constant));
        sb.append(Function.values()[this.function]);
        switch(this.operator){
            case 0:
                sb.append("+");
                break;
            case 1:
                sb.append("*");
                break;
            default:
                break;
        }
        sb.append(" ");
        return sb.toString();
    }
}
