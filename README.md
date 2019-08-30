# Library Entrance System

## 개요
시험기간 동안에만 생기는 열람실 좌석 부족 현상을 해결하기 위해 문서로만 작성 된 좌석 자동반납과 패널티 부여 기능을
갖는 새로운 출입 시스템을 간략하게 gui로 개발한다.

## 사용된 환경 & version

- windows 10 (64bit)
- Eclipse committers oxygen
- jdk-9.0.4
- e(fx)clipse plug-in

## 사용 시 주의사항

**Enter, Exit, Seat reservation 모두 StudentID를 등록 후 이용가능**
- *StudentID*를 등록하기 위해서는 *Manager*를 선택하여 관리자 *id*와 *password*를 입력해야함
    - 관리자 **ID: lang0909** , **password: 123123** (변경가능)
        ```java
        //in Controller.java
        if(s1.equals("lang0909") && s2.equals("123123")) //앞의 lang0909가 id 부분, 뒤의 123123부분이 password부분
        ```
    - *StudentID*는 **9자리 이며 숫자만 사용가능**

- penalty 3회 이상인 경우 출입제재 기간은 마지막 penalty 받은 날짜 +3일로 설정
- 좌석을 가지고 있는 상태에서 exit한지 1분 경과하면 penalty추가
    - 시험기간 중 자리 부족의 최대 원인은 자리 선점 후 밖에 있는 경우라 생각하여 설정(시간 설정 변경 가능)
        ```java
        //in Controller.java
        if(seatlist[i]==Integer.parseInt(foo1))
		{
			time[i][1] = addTime(time[i][0],1); //addTime의 숫자 변경으로 변경가능
			System.out.println(time[i][0]);
			System.out.println(time[i][1]);
		}
        ```
        
        ```java
        //in Main.java
        if(Integer.parseInt(Controller.time[i][1].substring(0,4))-Integer.parseInt(str1.substring(0,4))<1) //시간 설정 변경한 숫자로 <1 역시 변경해야함
        ```
        
    - 다시 enter로 들어오게 되면 원래 반납시간으로 다시 변경(현재 예약후 반납시간은 예약시간 +4분 시간설정 변경가능)
        ```java
        //in Controller.java
        for(int i=0;i<96;i++)
		{
			if(seatlist[i]==Integer.parseInt(foo))
			{
				time[i][1] = addTime(time[i][0],4); //addTime의 숫자 변경으로 변경가능
			}
		}
        ```
        

## 기능 설명

- **Enter**
    - 등록 된 StudentID인 경우
        - "어서오십시오!" message 생성
    - 등록되지 않은 StudentID인 경우
        - "등록되지 않은 사람입니다!" message 생성

- **Exit**
    - 들어온 기록이 있는 경우
        - "안녕히 가십시오!" message 생성
    - 들어온 기록이 없는 경우
        - penalty 1회 부여 (들어오지 않고 나간다는 것은 결국 들어올 때 출입게이트를 이용하지 않았다는 뜻이기 때문)

- **Manager**
    - 관리자 id와 password를 입력하면 관리자 기능을 사용가능
        - **Student Register**
            - StudentID 등록 가능(**9자리 이며 숫자만 사용가능**)
        - **Student delete**
            - 등록되어 있는 StudentID 삭제 가능(StudentID를 입력하고 성공하면 "삭제되었습니다" message 생성)
        - **Penalty Show**
            - 등록되어 있는 StudentID로 penalty를 받은 '날짜', '시간', '이유'를 보여줌(만약 penalty가 3회 이상인 경우 출입제재 만료 날짜도 보여줌)
        - **Penalty delete**
            - 혹시 잘못 된 입력으로 인한 penalty 부여시 관리자가 StudentID와 삭제할 penalty갯수를 입력하면 penalty갯수만큼 삭제

- **Seat**
    - 누르면 StudentID입력 창 생성
        - enter를 통과하지 않고 온 경우 penalty 1회 얻게 됨
        - enter를 통과하고 온 경우 RoomInfo 창 생성
            - 3개의 room으로 구분되어 있고 room을 누르면 seatInfo 창 생성
            - 좌석을 선택하면 "좌석예약이 완료되었습니다" message창 생성
    - 이미 좌석을 가지고 있는 경우
        - option 선택창 생성(좌석 반납예정 시간에서 2시간 미만인 경우에만 extend버튼 활성화)
            - return 선택시 좌석 반납
            - extend 선택시 좌석 시간  연장

## 시연 영상

**화면 클릭시 영상으로 이동**
[![Video Label](http://img.youtube.com/vi/Jvz2pz4dUV8/0.jpg)](https://www.youtube.com/watch?v=Jvz2pz4dUV8&t=17s)