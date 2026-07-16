class Solution {
    public void solve(char[][] board) {

        if (board == null || board.length ==0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new ArrayDeque();

        for (int r=0; r<rows; r++) {

            if(board[r][0] == 'O') {
                board[r][0] = '#';
                queue.offer(new int[]{r,0});
            }

            if (board[r][cols-1] == 'O') {
                board[r][cols-1] = '#';
                queue.offer(new int[]{r,cols-1});
            }
        }

        for (int c=0; c < cols; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = '#';
                queue.offer(new int[]{0,c});
            }

            if (board[rows-1][c] == 'O') {
                board[rows-1][c] = '#';
                queue.offer(new int[]{rows-1,c});
            }
        }

        int[] dr = {-1,0,1,0,-1};

        while(!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int r = currCell[0];
            int c = currCell[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dr[d+1];

                if (nr>=0 && nc>=0 && nr<rows && nc<cols && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols;c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
