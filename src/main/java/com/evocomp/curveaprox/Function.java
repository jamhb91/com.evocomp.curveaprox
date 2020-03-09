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
public enum Function {
    ZERO(10),
    NOFUNC(9),
    LOG10(8),
    LOG(7),
    SQRT(6),
    POW(5),
    EXP(4),
    TAN(3),
    SIN(2),
    COS(1)
    ;
    
    private final int functionCode;

    Function(int functionCode) {
        this.functionCode = functionCode;
    }
    
    public int getLevelCode() {
        return this.functionCode;
    }
}
