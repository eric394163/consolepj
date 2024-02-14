# 게시판 관리 프로그램에 필요한 쿼리문
use board;

# 카테고리 조회		=====================================
# c_num 오름차순(등록순)
SELECT CONCAT("---", c_name, "---") as "카테고리 명" FROM category	# 카테고리명 양 옆에 '--'를 붙여서 카테고리명 처럼 보이게 함...
	ORDER BY c_num ASC;
    
# 게시판 조회		=====================================
# 전체 게시판 조회
SELECT b_name as "게시판 이름", CONCAT("---", c_name, "---") as "카테고리 명" FROM board
	JOIN category ON b_c_num = c_num
    ORDER BY b_num;

# 특정 카테고리의 게시판 조회(취미 게시판)
SELECT b_name as "---취미 게시판---" -- , Idx # 임의의 번호를 부여하는 방법이 있었던 거 같은데...?
	FROM 
		(SELECT * FROM category
		WHERE c_name = "취미 게시판") as ct_sub 
	JOIN board ON b_c_num = c_num
    ORDER BY b_num;


# 게시글 조회		=====================================
# 전체 게시글 조회 (등록 날짜 순서대로)
SELECT p_title as "제목", p_u_id as 작성자, p_date as 작성일, p_view as 조회수
	FROM post
    JOIN board ON p_b_num = b_num
    ORDER BY p_date;

# 특정 카테고리와 게시판의 게시글 조회 (자유 게시판)
SELECT p_title as "제목", p_u_id as 작성자, p_date as 작성일, p_view as 조회수
	FROM 
		(SELECT * FROM board
        WHERE b_name = "자유 게시판") as bo_sub
    JOIN post ON p_b_num = b_num
    ORDER BY p_date;
