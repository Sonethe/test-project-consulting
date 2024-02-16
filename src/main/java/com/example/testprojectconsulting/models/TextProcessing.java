package com.example.testprojectconsulting.models;

public class TextProcessing {
    private String inpText;
    private boolean checkedText = false;

    public TextProcessing() {}

    public String getInpText() {
        return inpText;
    }

    public void setInpText(String inpText) {
        this.inpText = inpText;
        this.checkedText = !inpText.isEmpty();
    }

    public boolean getChecked() {
        return checkedText;
    }

    public void setChecked(boolean checked) {
        this.checkedText = checked;
    }
}
