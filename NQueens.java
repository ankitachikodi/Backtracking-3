class Solution {
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int [][] board = new int[n][n];

        placeQueens(board,0,n);

        return results;

    }

    public boolean placeQueens (int board[][],int r,int n) {
        //base case
        if(r==n) {

            List<String> temp= new ArrayList<>();

            for(int i=0;i<n;i++) {

                String a =new String();

                for(int j=0;j<n;j++) {

                    if(board[i][j]==1)
                        a+='Q';
                    else
                        a+='.';
                }
                temp.add(a);

            }

            results.add(temp);
            return false;

        }

        //recursive case

        for(int i=0;i<n;i++) {

            if(issafe(board,r,i,n)) {

                board[r][i]=1;
                if(placequeens(board,r+1,n))
                    return true;
            }

            board[r][i]=0;
        }

        return false;

    }

    public boolean issafe(int board[][],int i,int j,int n) {
        System.out.println("i: "+i+" j: "+j);

        for(int r=0; r<i; r++) {

            if(board[r][j]==1) {
                return false;
            }

        }

        //left diagonal

        System.out.println("i: "+i+" j: "+j);

        int x = i-1;
        int y = j-1;

        System.out.println("x: "+x+" y: "+y);

        while(x>=0 && y>=0) {

            System.out.println("x: "+x+" y: "+y);

            if(board[x][y]==1)
                return false;
            x--;
            y--;

        }

        //right diagonal

        x=i-1;
        y=j+1;

        while(x>=0 && y<n) {

            if(board[x][y]==1)
                return false;

            x--;
            y++;
        }
        return true;

    }

}