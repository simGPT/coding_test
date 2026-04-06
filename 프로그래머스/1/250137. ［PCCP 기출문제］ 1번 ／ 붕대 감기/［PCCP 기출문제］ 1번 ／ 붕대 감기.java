class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int stand = health;
        int re = 0; // 연속 성공 시간
        boolean isAttack = false;
        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            isAttack = false; // 리셋
            for(int j=0;j<attacks.length;j++){
                if(attacks[j][0]==i) { // 현재 시각 = 공격 받는 시간이 맞을때
                    health -= attacks[j][1]; // 피해량 만큼 깎인다
                    re = 0;
                    isAttack = true;
                }
            }
            if(!isAttack){
                health+=bandage[1];
                re++; // 계속 공격이 없을땐 연속 성공 시간 증가
                if(re==bandage[0]) { // 연속 성공
                    health += bandage[2]; // 추가 회복 더하기
                    re = 0;
                }
                if(health>stand) {
                    health = stand;
                
                }
            }

            if(health<=0) // 죽으면 -1
                return -1;
        }
        return health;
    }
}