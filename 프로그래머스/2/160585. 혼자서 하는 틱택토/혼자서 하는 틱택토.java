import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    
    // 게임판 상태와 다음 차례 플레이어를 함께 저장할 내부 클래스
    static class State {
        String[] board;
        char nextPlayer;

        State(String[] board, char nextPlayer) {
            this.board = new String[3];
            // 배열을 깊은 복사하여 상태가 서로 영향을 주지 않도록 함
            for(int i=0; i<3; i++) {
                this.board[i] = board[i];
            }
            this.nextPlayer = nextPlayer;
        }

        // Set에서 중복 확인을 위해 board 상태를 하나의 문자열로 변환
        public String boardToString() {
            return board[0] + board[1] + board[2];
        }
    }
    
    public int solution(String[] board) {
        // BFS 탐색을 위한 큐와 방문 기록을 위한 Set
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 1. 시작 상태(빈 보드, 'O'가 둘 차례)를 큐에 추가
        String[] initialBoard = {"...", "...", "..."};
        queue.add(new State(initialBoard, 'O'));
        visited.add(new State(initialBoard, 'O').boardToString());

        // 2. BFS 탐색 시작
        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            String currentBoardStr = currentState.boardToString();

            // 3. 현재 상태가 문제에서 주어진 board와 일치하는지 확인
            if (currentBoardStr.equals(board[0] + board[1] + board[2])) {
                // 정상적인 과정으로 만들어진 판이므로 1 반환
                return 1;
            }

            // 4. 게임 종료 상태인지 확인 (승자가 있거나, 판이 꽉 찼거나)
            if (isGameEnd(currentState.board)) {
                // 더 이상 진행할 수 없으므로 다음 탐색으로 넘어감
                continue;
            }
            
            // 5. 다음 상태 생성 및 큐에 추가
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 빈 칸에 돌을 놓아 다음 상태를 만듦
                    if (currentState.board[i].charAt(j) == '.') {
                        String[] nextBoard = currentState.board.clone();
                        // 문자열은 불변이므로 StringBuilder를 사용해 수정
                        StringBuilder sb = new StringBuilder(nextBoard[i]);
                        sb.setCharAt(j, currentState.nextPlayer);
                        nextBoard[i] = sb.toString();
                        
                        // 다음 플레이어 결정
                        char nextTurnPlayer = (currentState.nextPlayer == 'O') ? 'X' : 'O';
                        
                        State nextState = new State(nextBoard, nextTurnPlayer);
                        String nextBoardStr = nextState.boardToString();
                        
                        // 아직 방문하지 않은 상태라면 큐와 Set에 추가
                        if (!visited.contains(nextBoardStr)) {
                            visited.add(nextBoardStr);
                            queue.add(nextState);
                        }
                    }
                }
            }
        }
        
        // 6. 큐가 비었는데도 주어진 board를 못 찾았다면 0 반환
        return 0;
    }

    // 게임이 종료되었는지 확인하는 헬퍼 메서드
    private boolean isGameEnd(String[] board) {
        // 승자 확인
        if (checkWin('O', board) || checkWin('X', board)) {
            return true;
        }
        // 판이 꽉 찼는지 확인
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == '.') {
                    return false; // 빈 칸이 있으면 아직 안 끝남
                }
            }
        }
        return true; // 빈 칸이 없으면 끝남
    }
    
    // 승리 여부 확인 헬퍼 메서드 (이전 코드와 동일)
    private boolean checkWin(char player, String[] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;
        return false;
    }
}