CREATE DEFINER=`as_evse`@`localhost` PROCEDURE `as_evse`.`insert_check_default_data`(
    IN p_company_idx INT,
    IN p_manager_idx INT,
    IN p_charger_station_idx INT,
    IN p_distribution_idx INT
)
BEGIN
	DECLARE m_check_mst_idx INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    
    START TRANSACTION;
	
	INSERT INTO checkMst (company_idx, manager_idx, charger_station_idx, distribution_idx) VALUES (p_company_idx, p_manager_idx, p_charger_station_idx, p_distribution_idx);
	SET m_check_mst_idx = LAST_INSERT_ID();
	
	INSERT INTO compatibility (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO environment (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO convenience (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO product_safety (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO electrical_stability (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO fire_safety (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO maintenance (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO charging_operation (check_mst_idx) VALUES (m_check_mst_idx);
	INSERT INTO opinion (check_mst_idx) VALUES (m_check_mst_idx);
	
    COMMIT;
END