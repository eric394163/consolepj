# AUTO_INCREMENT를 이용하면, 기존에 있던 ROW들을 모두 삭제해도 그 뒤의 번호로 자동으로 등록됨!!
	# EX) 1 2 3번 ROW를 삭제하고 새로 데이터를 삽입하면, 새로 1번의 데이터가 생성되는 것이 아닌 4번 부터 생성됨! 
	# 기본키를 직접적으로 사용하지 않는 쿼리를 사용하면 괜찮을 거 같긴 하지만...

USE board;

-- DELETE FROM category; # 카테고리의 모든 열 삭제하기
# 카테고리 생성		=======================================================
INSERT INTO category(c_name) VALUE("자유 게시판"); 				# 1번
INSERT INTO category(c_name) VALUE("취미 게시판"); 				# 2번
INSERT INTO category(c_name) VALUE("~반드시 알아야 할 생활 꿀팁!!~"); # 3번

# AUTO_INCREMENT 누적으로 인해 번호가 다를 경우 값을 임의로 변경함.
UPDATE category SET c_num = 1 WHERE c_name ="자유 게시판";
UPDATE category SET c_num = 2 WHERE c_name ="취미 게시판";
UPDATE category SET c_num = 3 WHERE c_name ="~반드시 알아야 할 생활 꿀팁!!~";

SELECT * FROM category;

-- DELETE FROM board;
# 게시판 생성		=======================================================
-- "자유 게시판" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("이모저모", 1);	# 1번

-- "취미 게시판" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("뜨개질", 2);	# 2번
INSERT INTO board(b_name, b_c_num) VALUE("운동", 2);		# 3번
INSERT INTO board(b_name, b_c_num) VALUE("기타", 2);		# 4번

-- "~반드시 알아야 할 생활 꿀팁!!~" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("요리", 3);		# 5번
INSERT INTO board(b_name, b_c_num) VALUE("다이어트", 3);	# 6번
INSERT INTO board(b_name, b_c_num) VALUE("기타", 3);		# 7번

# AUTO_INCREMENT 누적으로 인해 번호가 다를 경우 값을 임의로 변경함.
UPDATE board SET b_num = 1 WHERE b_name ="이모저모";
UPDATE board SET b_num = 2 WHERE b_name ="뜨개질";
UPDATE board SET b_num = 3 WHERE b_name ="운동";
UPDATE board SET b_num = 4 WHERE b_name ="기타";
UPDATE board SET b_num = 5 WHERE b_name ="요리";
UPDATE board SET b_num = 6 WHERE b_name ="다이어트";
UPDATE board SET b_num = 7 WHERE b_name ="기타";

SELECT b_num, b_name, b_c_num as "카테고리 번호", c_name as "카테고리"
	FROM board
    JOIN category on b_c_num = c_num;

# 게시글 생성		=======================================================
#  (유저 아이디가 필요해서 완성은 안함!)

-- "자유 게시판" 카테고리
-- "이모 저모" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "오늘 먹은 거 자랑", "오늘 아침 삼겹살 점심 햄버거 저녁 소곱창 먹었음\n(사진)\n(사진)\n(사진)\n\n번개모임 하길 잘한듯~!", "2024-01-23", "userID");	
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "소곱창 먹기 번개모임 후기", "아 요새 계속 소곱창 먹고 싶었는데 같이 먹을 사람이 없어서 이 카페 사람들이랑 모였다\n역시 소곱창은 사람이 많아야 존마탱!\n(사진)\n(사진)\n(사진)\n(사진)\n(사진)", "2024-01-23", "userID");	
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "연남동 맛집 공유", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-10", "userID");	

-- "취미 게시판" 카테고리
-- "뜨개질" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 1", "뜨개질 취미 TEST 1 내용", "2024-01-21", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 2", "뜨개질 취미 TEST 2 내용", "2022-01-15", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "뜨개질 취미 TEST 3", "뜨개질 취미 TEST 3 내용", "2023-02-01", "userID");
-- "운동" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 1", "운동 취미 TEST 1 내용", "2023-01-23", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 2", "운동 취미 TEST 2 내용", "2024-02-15", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 3", "운동 취미 TEST 3 내용", "2024-01-01", "userID");
-- "기타" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 1", "기타 취미 TEST 1 내용", "2024-01-23", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 2", "기타 취미 TEST 2 내용", "2024-02-15", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "기타 취미 TEST 3", "기타 취미 TEST 3 내용", "2024-01-01", "userID");

-- "~반드시 알아야 할 생활 꿀팁!!~" 카테고리
-- "요리" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 1", "요리 꿀팁 TEST 1 내용", "2023-12-21", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 2", "요리 꿀팁 TEST 2 내용", "2022-11-12", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "요리 꿀팁 TEST 3", "요리 꿀팁 TEST 3 내용", "2024-02-03", "userID");
-- "다이어트" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 1", "다이어트 꿀팁 TEST 1 내용", "2023-12-21", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 2", "다이어트 꿀팁 TEST 2 내용", "2024-01-12", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "다이어트 꿀팁 TEST 3", "다이어트 꿀팁 TEST 3 내용", "2022-12-23", "userID");
-- "기타" 게시판의 게시글
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 1", "기타 꿀팁 TEST 1 내용", "2021-10-21", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 2", "기타 꿀팁 TEST 2 내용", "2022-05-12", "userID");
-- INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(7, "기타 꿀팁 TEST 3", "기타 꿀팁 TEST 3 내용", "2024-06-15", "userID");

# JOIN을 연달아 두 번 쓰는 대신 SubQuery를 사용할 수 있을까??
SELECT p_num, p_title, p_content, p_date, p_view, b_name as "게시판", c_name as "카테고리"
	FROM post
		JOIN board ON p_b_num = b_num
		JOIN category ON b_c_num = c_num;




