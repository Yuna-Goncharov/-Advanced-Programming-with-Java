package ex1;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Moaid Hathot on 11/11/2015.
 * This class represents a Polynomial. It uses a sorted, internal ArrayList of terms as the Polynomial terms.
 */
public final class Polynom {

    private ArrayList<Term> terms;

    public Polynom(double[] indeterminates, int[] coefficients){

        if(indeterminates.length != coefficients.length) {

            throw new IllegalArgumentException("The indeterminates array isn't the same length as the coefficients array");
        }

        terms = buildArrayList(indeterminates, coefficients);
    }

    private Polynom(ArrayList<Term> terms){


        // this constructor is private, so I can assume that the given terms ArrayList won't change.
        // otherwise, I'll have to shallow-copy it (terms are already Immutable) so I'll guarantee it won't change in the future.
        //this.terms = new ArrayList<>(terms);
        this.terms = terms;
    }

    // builds a sorted ArrayList<Term> from the two arrays.
    private ArrayList<Term> buildArrayList(double[] indeterminates, int[] coefficients){

        Map<Integer, List<Double>> sortedMap = createSortedMap();

        for(int index = 0; index < indeterminates.length; ++index){

            if(0 != indeterminates[index]) {

                int key = coefficients[index];

                if(!sortedMap.containsKey(key)){

                    sortedMap.put(key, new LinkedList<>());
                }

                sortedMap.get(key).add(indeterminates[index]);
            }
        }

        return buildArrayListFromMap(sortedMap);
    }

    // Uses a sorted map to sort and to eliminate unnecessary/duplicate terms.
    private ArrayList<Term> buildArrayListFromMap(Map<Integer, List<Double>> map){

        ArrayList<Term> terms = new ArrayList<>(map.size());

        for(Integer key : map.keySet()){

            double value = 0;

            for(Double indeterminate : map.get(key)){

                value += indeterminate;
            }

            if(0 != value){

                terms.add(new Term(key, value));
            }
        }

        return terms;
    }

    private Map<Integer, List<Double>> createSortedMap(){

        return new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });
    }

    // Used internal for calculations. This is a public method since it can be used for other things.
    // Even though it is not in the required API. I didn't get an interface specification, so I assume that this is ok.
    public Polynom neg(){

        ArrayList<Term> terms = new ArrayList<>(this.terms.size());

        for(Term term : this.terms){

            terms.add(term.neg());
        }

        return new Polynom(terms);
    }

    // Actually this is not used in the final version (read the comments for the 'plus' method)
    private void addTermsToMap(Collection<Term> terms, Map<Integer, List<Double>> map){

        for(Term term : terms) {

            int key = term.getCoefficient();
            double value = term.getIndeterminates();

            if (!map.containsKey(key)) {

                map.put(key, new LinkedList<>());
            }

            map.get(key).add(value);
        }
    }

    public Polynom plus(Polynom p)
    {
        // this way is shorter and more elegant, but it's time complexity is higher because of the TreeMap.
        // that way's time complexity is O(nlogn) while, bellow's (long) code complexity is more efficient O(n)
        //Map<Integer, List<Double>> sortedMap = createSortedMap();

        //addTermsToMap(terms, sortedMap);
        //addTermsToMap(p.terms, sortedMap);

        //return new Polynom(buildArrayListFromMap(sortedMap));

        if(!this.terms.isEmpty() && !p.terms.isEmpty()){

            int biggerIndex = 0;
            int smallerIndex = 0;

            Polynom biggerDegree;
            Polynom smallerDegree;

            if(this.getDegree() >= p.getDegree()){

                biggerDegree = this;
                smallerDegree = p;
            }
            else{

                biggerDegree = p;
                smallerDegree = this;
            }

            ArrayList<Term> terms = new ArrayList<>(biggerDegree.terms.size());

            while(biggerIndex < biggerDegree.terms.size() || smallerIndex < smallerDegree.terms.size()){

                if(biggerIndex >= biggerDegree.terms.size()){

                    terms.add(smallerDegree.terms.get(smallerIndex));
                    ++smallerIndex;
                }
                else if(smallerIndex >= smallerDegree.terms.size()){

                    terms.add(biggerDegree.terms.get(biggerIndex));
                    ++biggerIndex;
                }
                else{

                    Term biggerValue = biggerDegree.terms.get(biggerIndex);
                    Term smallerValue = smallerDegree.terms.get(smallerIndex);

                    if(biggerValue.getDegree() > smallerValue.getDegree()){

                        terms.add(biggerValue);
                        ++biggerIndex;
                    }

                    if(smallerValue.getDegree() > biggerValue.getDegree()){

                        terms.add(smallerValue);
                        ++smallerIndex;
                    }

                    if(biggerValue.getDegree() == smallerValue.getDegree()){

                        Term result = biggerValue.plus(smallerValue);

                        // in case of one of the
                        if(0 != result.getIndeterminates()) {

                            terms.add(biggerValue.plus(smallerValue));
                        }

                        ++biggerIndex;
                        ++smallerIndex;
                    }
                }
            }

            return new Polynom(terms);
        }
        else if(this.terms.isEmpty() && p.terms.isEmpty()){

            return this;
        }
        else{

            return this.terms.isEmpty() ? p : this;
        }
    }


    public Polynom minus(Polynom p){

        return plus(p.neg());
    }

    public Polynom getDerivative(){

        ArrayList<Term> terms = new ArrayList<>(this.terms.size());

        for(Term term : this.terms){

            if(0 < term.getDegree()) {

                terms.add(term.derivative());
            }
        }

        return new Polynom(terms);
    }

    private int getDegree(){

        return terms.isEmpty() ? 0 : terms.get(0).getDegree();
    }

    @Override
    public String toString() {

        if(terms.isEmpty()){

            return "0";
        }

        StringBuilder builder = new StringBuilder("");

        for(Term term : terms){

            if(0 == builder.length()){

                builder.append(term.toString());
            }
            else{

                builder.append(String.format(" %s %s", term.isNegative() ? "-" : "+", term.toString(false)));
            }
        }

        return builder.toString();
    }
}
