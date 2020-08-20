/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

import fit5042.tutex.repository.entities.Loan;
import fit5042.tutex.calculator.MonthlyPaymentCalculator;

/**
 *
 * @author: keyang wang
 */
@ManagedBean(name = "loanManagedBean",eager = true)
@SessionScoped
public class LoanManagedBean implements Serializable {

    @EJB
    private MonthlyPaymentCalculator monthlyPaymentCalculator;
	
    private Loan loan;

    public LoanManagedBean() {
        this.loan = new Loan();

    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String calculate() {
        
        double monthlyPayment;
        //You will need to modify the monthlyPayment value and set it as the monthly payment 
        //attribute value into the loan instance
        //Please complete this method starts from here
        monthlyPayment = monthlyPaymentCalculator.calculate(loan.getPrinciple(), loan.getNumberOfYears(), loan.getInterestRate());
        loan.setMonthlyPayment(monthlyPayment);
        return "index";
    }
}
