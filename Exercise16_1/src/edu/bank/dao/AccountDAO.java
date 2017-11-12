package edu.bank.dao;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import edu.bank.domain.Account;



public class AccountDAO implements IAccountDAO {
	
	private SessionFactory sf= HibernateUtil.getSessionFactory();

	public void saveAccount(Account account) {

		sf.getCurrentSession().save(account);
	}

	public void updateAccount(Account account) {
	
		sf.getCurrentSession().saveOrUpdate(account);

	}

	public Account loadAccount(long accountnumber) {
		 return (Account)sf.getCurrentSession().load(Account.class, accountnumber);
	}

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {		
		Query query = sf.getCurrentSession().createQuery("From Account");
		return query.list();
		}

}
