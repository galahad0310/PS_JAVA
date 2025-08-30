import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        
        //String배열보단 char배열이 문자열 조작하기 쉬우니깐 바꿔줌
        char[][] graph = new char[storage.length][storage[0].length()];
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                graph[i][j] = storage[i].charAt(j);
            }
        }
        
        //요청마다 처리
        for(String request : requests){
            char c = request.charAt(0);
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[graph.length][graph[0].length];

            if(request.length() == 1){//지게차
                for(int i = 0; i<graph.length; i++){
                    if(i == 0 || i == graph.length - 1){//1행, 마지막행인경우
                        for(int j = 0; j<graph[0].length; j++){
                            if(graph[i][j] == ' '){
                                q.add(new int[]{i, j});
                            }else{
                                if(graph[i][j] == c){
                                    graph[i][j] = ' ';
                                }
                            }
                            visited[i][j] = true;
                        }
                    }else{//중간행인 경우
                        if(graph[i][0] == ' '){
                            q.add(new int[]{i, 0});
                        }else{
                            if(graph[i][0] == c){
                                graph[i][0] = ' ';
                            }
                        }

                        if(graph[i][graph[0].length - 1] == ' '){
                            q.add(new int[]{i, graph[0].length - 1});
                        }else{
                            if(graph[i][graph[0].length - 1] == c){
                                graph[i][graph[0].length - 1] = ' ';
                            }
                        }
                        visited[i][graph[0].length - 1] = true;
                        visited[i][0] = true;
                    }
                }

                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    for(int i = 0; i<4; i++){
                        int ny = curr[0] + dy[i];
                        int nx = curr[1] + dx[i];
                        
                        if(ny > 0 && ny < graph.length && nx > 0 && nx < graph[0].length && !visited[ny][nx]){
                            visited[ny][nx] = true;
                            if(graph[ny][nx] == ' '){
                                q.add(new int[]{ny, nx});
                            }else{
                                if(graph[ny][nx] == c){
                                    graph[ny][nx] = ' ';
                                }
                            }
                        }

                    }
                }

            }else{//크레인
                for(int i = 0; i<graph.length; i++){
                    for(int j = 0; j<graph[0].length; j++){
                        if(graph[i][j] == c){
                            graph[i][j] = ' ';
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i<graph.length; i++){
            for(int j = 0; j<graph[0].length; j++){
                if(graph[i][j] != ' ') cnt++;
            }
        }
        return cnt;
    }
}