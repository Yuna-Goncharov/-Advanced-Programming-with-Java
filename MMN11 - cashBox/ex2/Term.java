package ex1;

/**
 * Created by Moaid Hathot on 11/11/2015.
 * This class will represent a Polynomial 'Term', as a member in the Polynom which consist of a coefficient and an indeterminate.
 */
public class Term implements Comparable{

    private int coefficient;
    private double indeterminates;

    public Term(int coefficient, double indeterminate){

        this.coefficient = coefficient;
        this.indeterminates = indeterminate;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Term)){

            return false;
        }

        if(this == obj){

            return true;
        }

        Term casted = (Term)obj;

        return getCoefficient() == casted.getCoefficient() && getIndeterminates() == casted.getIndeterminates();
    }

    @Override
    public int hashCode() {

        return toString().hashCode();
    }

    @Override
    public String toString() {

        return toString(true);
    }

    public String toString(boolean useSign) {

        return String.format("%s%s", useSign ? getIndeterminates() : Math.abs(getIndeterminates()), isFreeTerm() ? "" : String.format("^%d", getCoefficient()));
    }

    // Adds to terms
    public Term plus(Term term){

        if(term.getCoefficient() != getCoefficient()){

            throw new IllegalArgumentException(String.format("Only two terms with the same coefficient can be part of the plus/minus operation. Current Term's coefficient is %d while the other one is %d", getCoefficient(), term.getCoefficient()));
        }

        return new Term(getCoefficient(), getIndeterminates() + term.getIndeterminates());
    }

    // Substracts two terms
    public Term minus(Term term){

        return plus(term.neg());
    }

    // Derive a term
    public Term derivative (){

        return new Term(getCoefficient() - 1, getCoefficient() * getIndeterminates());
    }

    // negates the term
    public Term neg(){

        return new Term(getCoefficient(), - getIndeterminates());
    }

    public boolean isNegative(){

        return 0 > getIndeterminates();
    }

    public boolean isFreeTerm(){

        return 0 == getCoefficient();
    }

    public int getDegree(){

        return getCoefficient();
    }

    public int getCoefficient() {
        return coefficient;
    }

    public double getIndeterminates() {
        return indeterminates;
    }

    @Override
    public int compareTo(Object o) {

        Term casted = (Term)o;

        return casted.getCoefficient() - getCoefficient();
    }
}
