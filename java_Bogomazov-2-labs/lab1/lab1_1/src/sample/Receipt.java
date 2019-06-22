package sample;

import java.util.Objects;

public class Receipt {

    private String text = "";
    private int valuePerWord = 2;

    public void setValuePerWord(int value) {
        this.valuePerWord = value;
    }

    public void setText(String text) {
        this.text = text;
    }

    Receipt() {

    }

    Receipt(String text) {
        this.text = text;
    }


    public int outputReceipt() {
        return text.split("\\W+").length * valuePerWord;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "text='" + text + '\'' +
                ", valuePerWord=" + valuePerWord +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return valuePerWord == receipt.valuePerWord &&
                Objects.equals(text, receipt.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, valuePerWord);
    }
}
