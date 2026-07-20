SET SERVEROUTPUT ON;
DECLARE
    -- Cursor to fetch loans for customers over 60 years old
    CURSOR c_senior_loans IS
        SELECT c.customer_id, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
BEGIN
    FOR r_loan IN c_senior_loans LOOP
        -- Apply a 1% discount to the current interest rate
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = r_loan.loan_id;
    END LOOP;
    
    -- Save the changes to the database
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior citizen discounts applied successfully.');
END;
/

DECLARE
    -- Cursor to find customers with high balances
    CURSOR c_high_balance IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000;
BEGIN
    FOR r_cust IN c_high_balance LOOP
        -- Update the VIP flag
        UPDATE customers
        SET is_vip = 'TRUE' 
        WHERE customer_id = r_cust.customer_id;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP statuses updated successfully.');
END;
/

DECLARE
    -- Cursor to fetch loans due in the next 30 days
    CURSOR c_due_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    FOR r_loan IN c_due_loans LOOP
        -- Print the reminder message for each customer
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || r_loan.customer_name || 
                             ', your loan (ID: ' || r_loan.loan_id || 
                             ') is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
