package lab1java;

class Sentiment {
    private String name;
    private double value;
    public Sentiment(String name, double value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return "Name: "+name+" | Value: "+value;
    }
}