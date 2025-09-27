CREATE DEFINER=`as_evse`@`localhost` PROCEDURE `as_evse`.`insert_check_default_data`(
    IN p_company_idx INT,
    IN p_manager_idx INT,
    IN p_charger_station_idx INT,
    IN p_distribution_idx INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    
    START TRANSACTION;
    
    COMMIT;
END