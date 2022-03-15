# java-blackjack

블랙잭 미션 저장소


## Participants
* BE_마루
* BE_앤지

## 기능목록
* 참여할 사람의 이름을 입력받는다. 
  * 쉼표를 기준으로 이름을 분리한다.
  * 예외사항
    * 이름에 아무것도 들어오지 않을 때(공백)
    * 쉼표만 입력 받았을 때
    * 플레이어 인원이 1~8이 아닐 때


* 참여자들에게 배팅 금액을 입력 받는다.


* 참여자들에게 카드를 두장씩 나누어준다.


* 참여자들은 자신의 카드를 오픈한다.
  * 딜러는 한장만 오픈한다.
  * 플레이어는 두장을 다 오픈한다.


* 만일 딜러의 카드가 블랙잭이라면 게임의 승패를 가르고 종료한다.
  * 플레이어 중에 블랙잭이 존재하면 해당 플레이어는 무승부이다.
    * 베팅 금액을 돌려 받는다
  * 나머지 플레이어는 모두 패배이다.
* 만일 플레이어만 블랙잭이면 해당 플레이어는 무조건 승리이다.
  * 베팅 금액의 1.5 배를 딜러에게 받는다


* 게임이 계속 진행 될 경우, 플레이어들은 카드를 더 받을지 결정하고 출력한다.
  * 플레이어의 카드의 합이 21미만일 때만 카드를 더 받을 것인지를 물어본다.
    * 에이스를 가진 경우 유리한 쪽으로 계산한다.
  * 플레이어가 y를 입력하면 카드를 더 받는다.
  * 플레이어가 n을 입력하면 카드를 더 받지 않는다.
  * 예외사항
    * y혹은 n을 입력받지 않았을 때
  * 21점을 넘어가면 Bust이며 패배이다.
    * 베팅 금액을 모두 잃는다.

    
* 딜러의 합계가 16이하이면 16을 넘을 때 까지 카드를 계속 받는다.


* 딜러와 플레이어가 가진 카드의 숫자의 합을 계산하고 출력한다. 
  * 에이스는 유리한쪽으로 계산한다.

  
* 승패를 출력하는 기능
  * 앞서 승패가 결정된 플레이어는 결과를 그대로 둔다.
  * 딜러가 버스트 되면, 버스트 되지 않은 모든 플레이어가 승리이다. 
    * 베팅 금액 만큼 수익을 얻는다.
  * 딜러가 버스트 되지 않으면, 카드 총합이 21에 더 가까운 사람이 승리이다.
  * 딜러는 모든 플레이어에 대해 승패의 합을 출력한다.
  * 플레이어는 딜러를 기준으로 승패를 출력한다.


* (2단계) 최종 수익을 출력하는 기능 - 딜러, 플레이어
  * 플레이어가 블랙잭인 경우 베팅 금액 1.5배의 수익을 얻는다.
  * 딜러에게 이긴 경우 베팅 금액 만큼 수익을 얻는다.
  * 딜러와 비긴 경우 베팅 금액을 돌려받는다.(수익 0원)
  * 딜러에게 진 경우 베팅 금액 만큼 손해를 입는다.


## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

