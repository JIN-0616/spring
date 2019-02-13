SELECT * FROM (
				SELECT * FROM (
					SELECT ROWNUM row_num, bo.num, bo.filename, bo.mem_id, bo.indate, bo.title FROM  (
						SELECT b.*, c.view_cnt as view_cnt FROM board b
                    		LEFT OUTER JOIN (
		                 			SELECT BOARD_NUM, NVL(COUNT(MEM_NUM),0) as VIEW_CNT FROM  BOARD_LIKES GROUP BY BOARD_NUM
		            		) c ON b.num = c.board_num ORDER BY b.num DESC
		          ) bo
           ) WHERE row_num >= 1
         ) WHERE row_num <= 10