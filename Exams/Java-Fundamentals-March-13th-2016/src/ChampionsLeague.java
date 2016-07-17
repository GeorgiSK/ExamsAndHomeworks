import java.util.*;

public class ChampionsLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        TreeMap<String, TreeMap<Integer, Set<String>>> teamInfo = new TreeMap<>();

        while (!(input = scanner.nextLine()).equals("stop")) {
            String[] currentLine = input.trim().split("[|]");
            String teamOne = currentLine[0].trim();
            String teamTwo = currentLine[1].trim();
            int teamOneGoals = Integer.parseInt(currentLine[2].trim().split(":")[0]) + Integer.parseInt(currentLine[3].trim().split(":")[1]);
            int teamTwoGoals = Integer.parseInt(currentLine[2].trim().split(":")[1]) + Integer.parseInt(currentLine[3].trim().split(":")[0]);
            int teamOneAwayGoals = Integer.parseInt(currentLine[3].trim().split(":")[1]);
            int teamTwoAwayGoals = Integer.parseInt(currentLine[2].trim().split(":")[1]);

            //TEAM ONE
            //////////////////////////////////////////////////////////////////////////////
            if (teamInfo.containsKey(teamOne)) {
                TreeMap<Integer, Set<String>> innerMap = teamInfo.get(teamOne);
                Set<String> innerSet = innerMap.get(innerMap.firstKey());
                innerSet.add(teamTwo);

                if (teamOneGoals > teamTwoGoals) {
                    innerMap.put(innerMap.firstKey() + 1, innerSet);
                    innerMap.remove(innerMap.firstKey());
                }else if (teamOneGoals == teamTwoGoals) {
                    if (teamOneAwayGoals > teamTwoAwayGoals) {
                        innerMap.put(innerMap.firstKey() + 1, innerSet);
                        innerMap.remove(innerMap.firstKey());
                    }
                }
            }else {
                teamInfo.put(teamOne, new TreeMap<>());
                TreeMap<Integer, Set<String>> innerMap = teamInfo.get(teamOne);
                innerMap.put(0, new TreeSet<>());
                Set<String> innerSet = innerMap.get(innerMap.firstKey());
                innerSet.add(teamTwo);

                if (teamOneGoals > teamTwoGoals) {
                    innerMap.put(1, innerSet);
                    innerMap.remove(0);
                }else if (teamOneGoals == teamTwoGoals) {
                    if (teamOneAwayGoals > teamTwoAwayGoals) {
                        innerMap.put(1, innerSet);
                        innerMap.remove(0);
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////

            //TEAM TWO
            //////////////////////////////////////////////////////////////////////////////
            if (teamInfo.containsKey(teamTwo)) {
                TreeMap<Integer, Set<String>> innerMap = teamInfo.get(teamTwo);
                Set<String> innerSet = innerMap.get(innerMap.firstKey());
                innerSet.add(teamOne);

                if (teamTwoGoals > teamOneGoals) {
                    innerMap.put(innerMap.firstKey() + 1, innerSet);
                    innerMap.remove(innerMap.firstKey());
                }else if (teamTwoGoals == teamOneGoals) {
                    if (teamTwoAwayGoals > teamOneAwayGoals) {
                        innerMap.put(innerMap.firstKey() + 1, innerSet);
                        innerMap.remove(innerMap.firstKey());
                    }
                }
            }else {
                teamInfo.put(teamTwo, new TreeMap<>());
                TreeMap<Integer, Set<String>> innerMap = teamInfo.get(teamTwo);
                innerMap.put(0, new TreeSet<>());
                Set<String> innerSet = innerMap.get(innerMap.firstKey());
                innerSet.add(teamOne);

                if (teamTwoGoals > teamOneGoals) {
                    innerMap.put(1, innerSet);
                    innerMap.remove(0);
                }else if (teamTwoGoals == teamOneGoals) {
                    if (teamTwoAwayGoals > teamOneAwayGoals) {
                        innerMap.put(1, innerSet);
                        innerMap.remove(0);
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////

        }

        /////////////////////////////////////////////////////////////
        String[] orderOfPrinting = new String[teamInfo.size()];
        int i = 0;

        for (String s : teamInfo.keySet()) {
            orderOfPrinting[i] = s;
            i++;
        }

        for (int j = 0; j < orderOfPrinting.length; j++) {
            for (int k = j; k < orderOfPrinting.length; k++) {
                int currentTeamWins = teamInfo.get(orderOfPrinting[j]).firstKey();
                int nextTeamWins = teamInfo.get(orderOfPrinting[k]).firstKey();
                if (currentTeamWins < nextTeamWins) {
                    String temp = orderOfPrinting[j];
                    orderOfPrinting[j] = orderOfPrinting[k];
                    orderOfPrinting[k] = temp;
                }
            }
        }

        for (int k = 0; k < orderOfPrinting.length; k++) {
            for (int j = 0; j < orderOfPrinting.length - 1; j++) {
                int currentTeamWins = teamInfo.get(orderOfPrinting[j]).firstKey();
                int nextTeamWins = teamInfo.get(orderOfPrinting[j + 1]).firstKey();
                if (currentTeamWins == nextTeamWins) {
                    if (orderOfPrinting[j].compareTo(orderOfPrinting[j + 1]) > 0) {
                        String temp = orderOfPrinting[j];
                        orderOfPrinting[j] = orderOfPrinting[j + 1];
                        orderOfPrinting[j + 1] = temp;
                    }
                }
            }
        }

        //Printing
        for (int j = 0; j < orderOfPrinting.length; j++) {
            int currentTeamWins = teamInfo.get(orderOfPrinting[j]).firstKey();
            Set<String> opponents = teamInfo.get(orderOfPrinting[j]).get(teamInfo.get(orderOfPrinting[j]).firstKey());
            System.out.println(orderOfPrinting[j]);
            System.out.println("- Wins: " + currentTeamWins);
            System.out.println("- Opponents: " + opponents.toString().replace('[', '\0').replace(']', '\0'));
        }

    }
}
