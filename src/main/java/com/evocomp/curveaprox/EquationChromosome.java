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
public class EquationChromosome {
    
    private PolinomialElement [] elements;
    private double deltaSum;
    
    /***
     * Constructs an element with a PolinomialElement Array
     * @param elements Array of PolinomialElements
     */
    public EquationChromosome(PolinomialElement [] elements){
        this.elements = elements;
    }
    
    /***
     * Constructs an element with a PolinomialElement Array and a delta value calculation
     * @param elements Array of PolinomialElements
     * @param deltaSum calculation of deltas of evaluation
     */
    public EquationChromosome(PolinomialElement [] elements, double deltaSum){
        this.deltaSum = deltaSum;
        this.elements = elements;
    }

    /**
     * @return the elements
     */
    public PolinomialElement[] getElement() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElement(PolinomialElement[] elements) {
        this.elements = elements;
    }

    /**
     * @return the deltaSum
     */
    public double getDeltaSum() {
        return deltaSum;
    }

    /**
     * @param deltaSum the deltaSum to set
     */
    public void setDeltaSum(double deltaSum) {
        this.deltaSum = deltaSum;
    }
}
