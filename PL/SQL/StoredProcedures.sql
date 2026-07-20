CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Apply a 1% interest rate to all savings accounts
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';
    
    -- Save the changes
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Calculate and add the bonus to the current salary
    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Employee bonuses updated successfully for department: ' || p_department_id);
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_current_balance NUMBER;
BEGIN
    -- 1. Check the current balance of the source account
    SELECT balance INTO v_current_balance
    FROM accounts
    WHERE account_id = p_from_account_id;

    -- 2. Verify sufficient funds
    IF v_current_balance >= p_amount THEN
        -- Deduct from the source account
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account_id;

        -- Add to the destination account
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_amount || ' completed successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Insufficient funds in the source account.');
    END IF;

EXCEPTION
    -- Handle the error if the account is not found
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Source account does not exist.');
    -- Rollback any partial updates if something else goes wrong
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/
