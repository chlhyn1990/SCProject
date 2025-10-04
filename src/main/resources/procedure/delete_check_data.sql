CREATE DEFINER=`as_evse`@`localhost` PROCEDURE `as_evse`.`delete_check_data`(
    IN p_check_mst_idx INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    
    START TRANSACTION;
	
	DELETE FROM compatibility WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM environment WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM convenience WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM product_safety WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM electrical_stability WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM fire_safety WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM maintenance WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM charging_operation WHERE check_mst_idx = p_check_mst_idx;
	DELETE FROM opinion WHERE check_mst_idx = p_check_mst_idx;
	
	DELETE FROM check_mst WHERE idx = p_check_mst_idx;
	
    COMMIT;
END