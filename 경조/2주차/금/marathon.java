public class marathon {
    public String solutino(String[] participant, String[] completion) {
        String answer = "";
        boolean[] complete = new boolean[participant.length];

        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if (!complete[j] && participant[j].equals(completion[i])) {
                    complete[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (!complete[i]) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
