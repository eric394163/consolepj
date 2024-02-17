# 게시글 생성		=======================================================
INSERT INTO user values("qwerty123", "abcd1234", "qwerty@naver.com", "010-1234-0987", "홍길동", 0, 0, 0);
select * from user;

-- "자유 게시판" 카테고리
-- "이모 저모" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "오늘 먹은 거 자랑", "오늘 아침 삼겹살 점심 햄버거 저녁 소곱창 먹었음\n(사진)\n(사진)\n(사진)\n\n번개모임 하길 잘한듯~!", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "소곱창 먹기 번개모임 후기", "아 요새 계속 소곱창 먹고 싶었는데 같이 먹을 사람이 없어서 이 카페 사람들이랑 모였다\n역시 소곱창은 사람이 많아야 존마탱!\n(사진)\n(사진)\n(사진)\n(사진)\n(사진)", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "연남동 맛집 공유", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-10", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 1", "자유 게시판 TEST 1", "2024-01-23", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 2", "자유 게시판 TEST 2", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 3", "자유 게시판 TEST 3", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 4", "자유 게시판 TEST 4", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 5", "자유 게시판 TEST 5", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 6", "자유 게시판 TEST 6", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 7", "자유 게시판 TEST 7", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 8", "자유 게시판 TEST 8", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 9", "자유 게시판 TEST 9", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 10", "자유 게시판 TEST 10", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 11", "자유 게시판 TEST 11", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 12", "자유 게시판 TEST 12", "2024-01-23", "qwerty123");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "자유 게시판 TEST 13", "자유 게시판 TEST 13", "2024-01-23", "qwerty123");	

-- "취미 게시판" 카테고리
-- "뜨개질" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 1", "뜨개질 취미 TEST 1 내용", "2024-01-21", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 2", "뜨개질 취미 TEST 2 내용", "2022-01-15", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 3", "뜨개질 취미 TEST 3 내용", "2023-02-01", "qwerty123");
-- "운동" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 1", "운동 취미 TEST 1 내용", "2023-01-23", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 2", "운동 취미 TEST 2 내용", "2024-02-15", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 3", "운동 취미 TEST 3 내용", "2024-01-01", "qwerty123");
-- "기타" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 1", "기타 취미 TEST 1 내용", "2024-01-23", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 2", "기타 취미 TEST 2 내용", "2024-02-15", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 3", "기타 취미 TEST 3 내용", "2024-01-01", "qwerty123");

-- "~반드시 알아야 할 생활 꿀팁!!~" 카테고리
-- "요리" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 1", "요리 꿀팁 TEST 1 내용", "2023-12-21", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 2", "요리 꿀팁 TEST 2 내용", "2022-11-12", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 3", "요리 꿀팁 TEST 3 내용", "2024-02-03", "qwerty123");
-- "다이어트" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 1", "다이어트 꿀팁 TEST 1 내용", "2023-12-21", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 2", "다이어트 꿀팁 TEST 2 내용", "2024-01-12", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 3", "다이어트 꿀팁 TEST 3 내용", "2022-12-23", "qwerty123");
-- "기타" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 1", "기타 꿀팁 TEST 1 내용", "2021-10-21", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 2", "기타 꿀팁 TEST 2 내용", "2022-05-12", "qwerty123");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 3", "기타 꿀팁 TEST 3 내용", "2024-06-15", "qwerty123");

# JOIN을 연달아 두 번 쓰는 대신 SubQuery를 사용할 수 있을까??
SELECT p_num, p_title, p_content, p_date, p_view, b_name as "게시판", c_name as "카테고리"
	FROM post
		JOIN board ON p_b_num = b_num
		JOIN category ON b_c_num = c_num
	ORDER BY p_date;




