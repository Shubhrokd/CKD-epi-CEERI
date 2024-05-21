package com.urbanmusleem.egfrcalculator;

public class CkdCategory {

    private String ckdCategory;

    public String getCkdCategory(int result) {
        if (result < 15) {
            ckdCategory = "CKD Stage 5";
        } else if (result >= 15 && result <= 29) {
            ckdCategory = "CKD Stage 4";
        } else if (result > 29 && result <= 44) {
            ckdCategory = "CKD Stage 3B";
        } else if (result > 44 && result <= 59) {
            ckdCategory = "CKD Stage 3A";
        } else if (result > 59 && result <= 89) {
            ckdCategory = "CKD Stage 2";
        } else {
            ckdCategory = "CKD Stage 1";
        }
        return ckdCategory;
    }
}
