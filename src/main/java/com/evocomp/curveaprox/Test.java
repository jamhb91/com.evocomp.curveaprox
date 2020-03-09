/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evocomp.curveaprox;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jamhb
 */
public class Test {
    public static void main(String[] args) {
        try {
            CurveFinder cf = new CurveFinder(4,100);
            List<EquationChromosome> matrix = cf.createMatrix();
            matrix.forEach((equationChromosome) -> {
                System.out.println(Arrays.toString(equationChromosome.getElement()) + " = " + equationChromosome.getDeltaSum());
            });
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
