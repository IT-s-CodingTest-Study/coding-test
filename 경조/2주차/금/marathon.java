class marathon {
    public String marathon(String[] participant, String[] completion) {
        String answer = "";
        // 방문 여부 확인
        boolean[] complete = new boolean[participant.length];
        // 완주자 명단만큼 반복
        for (int i = 0; i < completion.length; i++) {
            // 참가자 명단에서 조회되면 탈출
            for (int j = 0; j < participant.length; j++) {
                if (!complete[j] && participant[j].equals(completion[i])) {
                    complete[j] = true;
                    break;
                }
            }
        }
    }
}