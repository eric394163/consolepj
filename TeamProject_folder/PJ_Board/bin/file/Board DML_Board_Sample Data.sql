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
