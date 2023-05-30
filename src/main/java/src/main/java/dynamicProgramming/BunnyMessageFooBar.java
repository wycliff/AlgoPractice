package src.main.java.dynamicProgramming;

import java.util.*;

public class BunnyMessageFooBar {
    public static int solution(int[] l) {
        List<Integer> initList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        Queue<Integer> rem0queue = new LinkedList<>();
        Queue<Integer> rem1queue = new LinkedList<>();
        Queue<Integer> rem2queue = new LinkedList<>();

        StringBuilder sbResult = new StringBuilder();
        int result = 0, sum = 0, rem;

        for (int x : l) {
            if (x < 0) return result;
            initList.add(x);
        }

        Collections.sort(initList);
        //System.out.println(initList);

        for (int y : initList) {
            sum += y;
            if ((y % 3) == 0) rem0queue.add(y);
            else if ((y % 3) == 1) rem1queue.add(y);
            else rem2queue.add(y);
        }

        if (sum == 0) return result;
        rem = sum % 3;


        switch (rem) {
            case 0:
                rList.addAll(rem0queue);
                rList.addAll(rem1queue);
                rList.addAll(rem2queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList) sbResult.append(x);
                result = Integer.parseInt(sbResult.toString());
                break;

            case 1:
                if (!rem1queue.isEmpty()) rem1queue.remove();
                else {
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                }
                rList.addAll(rem1queue);
                rList.addAll(rem2queue);
                rList.addAll(rem0queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList)
                    sbResult.append(x);
                if (!sbResult.toString().equals(""))
                    result = Integer.parseInt(sbResult.toString());
                break;

            case 2:
                if (!rem2queue.isEmpty()) rem2queue.remove();
                else {
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                }
                rList.addAll(rem2queue);
                rList.addAll(rem1queue);
                rList.addAll(rem0queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList) sbResult.append(x);
                //if((Integer.parseInt(sbResult.toString())) % 3 != 0) return result;
                result = Integer.parseInt(sbResult.toString());
                break;
        }


        //System.out.println("Sum of digits " + sum + "\n" + "Rem num " + rem + "\n"+ "Result num " + sbResult);

        return result;
    }

    public static int solution2(int[] l) {
        List<Integer> initList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        Queue<Integer> rem0queue = new LinkedList<>();
        Queue<Integer> rem1queue = new LinkedList<>();
        Queue<Integer> rem2queue = new LinkedList<>();

        StringBuilder sbResult = new StringBuilder();
        int result = 0, sum = 0, rem;

        for (int x : l) {
            if (x < 0) return result;
            initList.add(x);
        }

        Collections.sort(initList);
        System.out.println(initList);

        for (int y : initList) {
            sum += y;
            if ((y % 3) == 0) rem0queue.add(y);
            else if ((y % 3) == 1) rem1queue.add(y);
            else rem2queue.add(y);

            System.out.println(rem0queue +": 0");
            System.out.println(rem1queue +": 1");
            System.out.println(rem2queue +": 2");
            System.out.println(" \n");
        }


        if (sum == 0) return result;
        rem = sum % 3;


        switch (rem) {
            case 0:
                rList.addAll(rem0queue);
                rList.addAll(rem1queue);
                rList.addAll(rem2queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList) sbResult.append(x);
                result = Integer.parseInt(sbResult.toString());
                break;

            case 1:
                if (!rem1queue.isEmpty()) rem1queue.remove();
                else {
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                    if (!rem2queue.isEmpty()) rem2queue.remove();
                }
                rList.addAll(rem1queue);
                rList.addAll(rem2queue);
                rList.addAll(rem0queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList)
                    sbResult.append(x);
                if (!sbResult.toString().equals(""))
                    result = Integer.parseInt(sbResult.toString());
                break;

            case 2:
                if (!rem2queue.isEmpty()) rem2queue.remove();
                else {
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                    if (!rem1queue.isEmpty()) rem1queue.remove();
                }
                rList.addAll(rem2queue);
                rList.addAll(rem1queue);
                rList.addAll(rem0queue);
                rList.sort(Collections.reverseOrder());

                for (int x : rList) sbResult.append(x);
                result = Integer.parseInt(sbResult.toString());
                break;
        }

        return result;
    }

    public static int answer(int[] l)
    {
        int b0[]=new int[10];
        int b1[]=new int[10];
        int b2[]=new int[10];
        int l1[]=new int[10];
        int b0n=0,b1n=0,b2n=0,l1n=0,sum=0;
        int ib1=0,ib2=0;
        for(int d : l)
        {
            sum+=d;
            l1[l1n++]=d;
            if(d%3==0)
                b0[b0n++]=d;
            else
            if(d%3==1)
                b1[b1n++]=d;
            else
            if(d%3==2)
                b2[b2n++]=d;
        }

        //System.out.println(sum);

        Arrays.sort(b0,0,b0n);
        Arrays.sort(b1,0,b1n);
        Arrays.sort(b2,0,b2n);

        if(sum%3==0)
        {
            int i,res=0;
            Arrays.sort(l1,0,l1n);
            for(i=l1n-1;i>=0;i--)
            {
                res=res*10+l1[i];
            }
            return res;
        }
        else
        if(sum%3==1)
        {
            if(b1n!=0)
                ib1++;
            else
            if(b2n>=2)
                ib2=ib2+2;
            else
                return 0;
        }
        else
        if(sum%3==2)
        {
            if(b2n!=0)
                ib2++;
            else
            if(b1n>=2)
                ib1=ib1+2;
            else
                return 0;
        }

        int fnl[]=new int[20];
        int i,fn=0,res=0;

        for(i=0;i<b0n;i++)
            fnl[fn++]=b0[i];
        for(i=ib1;i<b1n;i++)
            fnl[fn++]=b1[i];
        for(i=ib2;i<b2n;i++)
            fnl[fn++]=b2[i];

        Arrays.sort(fnl,0,fn);

        for(i=fn-1;i>=0;i--)
        {
            res=res*10+fnl[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] l = {3,1,4,1,5,9};
       // int[] l = {7};
        System.out.println(answer(l));
    }
}