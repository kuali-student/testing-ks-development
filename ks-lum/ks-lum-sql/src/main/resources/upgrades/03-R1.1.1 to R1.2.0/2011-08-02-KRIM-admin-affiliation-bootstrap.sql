UPDATE 	
		KRIM_ENTITY_EMP_INFO_T 
SET		
		EMP_STAT_CD = 'A' 
WHERE 	
		ENTITY_ID = (SELECT 
								ENTITY_ID 
					FROM 
								KRIM_PRNCPL_T 
					WHERE 
								PRNCPL_ID = 'admin')
/
    