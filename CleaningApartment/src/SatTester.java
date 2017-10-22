
import java.util.ArrayList;
import java.util.BitSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimstewart
 */
public class SatTester {
        public static boolean naiveSatTester(ArrayList<ArrayList<Integer>> sol){
        boolean truthVal = true;
        int maxInd = 0;
        for(ArrayList<Integer> clause:sol){
            for(Integer boolInd:clause){
                int i = Math.abs(boolInd);
                if(i>maxInd)
                    maxInd=i;
            }
        }
        BitSet[] possibleSolutions = new BitSet[1];
        long[] tmpLong = {(long)0x1041022};
        possibleSolutions[0] = BitSet.valueOf(tmpLong);
//        BitSet[] possibleSolutions = new BitSet[(int)Math.pow(2, maxInd)];
//        for(int i=0;i<possibleSolutions.length;i++){
//            long[] tmpLong = {(long)i};
//            possibleSolutions[i] = BitSet.valueOf(tmpLong);
//        }
        for(BitSet ps:possibleSolutions){
            truthVal = true;
            for(int i=0;i<sol.size();i++){
                ArrayList<Integer> clause=sol.get(i);
                boolean subVal = false;
                for(Integer boolInd:clause){
                    int ind = maxInd - (Math.abs(boolInd));
                    boolean b = boolInd<0?!ps.get(ind):ps.get(ind);
                    subVal = subVal || b;
                }
                truthVal = truthVal && subVal;
            }
            if(truthVal)
                return true;
        }
        return truthVal;
    }
        
        


}
