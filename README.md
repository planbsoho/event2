기능              |  Method   | URL           | request      | response       | 상태코드
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
일정만들기        |  POST     |url/schedules  |  날짜, 본문   |  id 날짜 본문   | 201 created
일정조회          | GET       | url/{date}    |  id          |  날짜 본문      | 200
일정수정(전체)    | PUT       |url/{id}       |  날짜         | 날짜 수정된값   | 200
일정삭제          | DELETE    |url/ {id}      |  날짜         | 날짜           | 204 No Content
