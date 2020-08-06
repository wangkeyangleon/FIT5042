package fit5042.tutex.calculator.mbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.tutex.calculator.MonthlyPaymentCalculator;
import fit5042.tutex.calculator.navigation.Navigation;
import fit5042.tutex.repository.entities.Loan;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：4 Aug 2020 3:37:07 pm
 * @desc:
 */
// this is java bean
@ManagedBean
@SessionScoped
public class LoanManagedBean implements Serializable {
	@EJB
	private MonthlyPaymentCalculator calculator;
	private Loan loan;

	public LoanManagedBean() {
		this.loan = new Loan();
	}

	public MonthlyPaymentCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(MonthlyPaymentCalculator calculator) {
		this.calculator = calculator;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public String calculate() {
		String result;		
		loan.setMonthlyPayment(calculator.calculate(getLoan().getPrinciple(), getLoan().getNumberOfYears(), getLoan().getInterestRate()));
		result = Double.toString(loan.getMonthlyPayment());
		return result;
	}

}
