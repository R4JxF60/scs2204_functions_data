class Account(val NIC: String, val accNo: Int, var balance: Double) {
    def transfer(amount: Double, that: Account): Unit = {
        this.balance -= amount
        that.balance += amount
    }
}


object Main {
    def main(args: Array[String]): Unit = {

        // Question 03
        println("Question 3.0\n")
        val acc1 = new Account("100000001v", 50001, 150000.50)
        val acc2 = new Account("100000004v", 40019, 98500.50)
        println("Before transfering : ");
        println("     "+acc1.accNo+" balance : "+acc1.balance)
        println("     "+acc2.accNo+" balance : "+acc2.balance)
        acc1.transfer(50000, acc2)
        println(" After transfering : ");
        println("     "+acc1.accNo+" balance : "+acc1.balance)
        println("     "+acc2.accNo+" balance : "+acc2.balance+"\n")

        // Question 04
        var bank: List[Account] = List(new Account("100100001v", 10001, 1458.50), new Account("100100002v", 10002, 0), new Account("100100003v", 10003, -5083.50), new Account("100100004v", 10004, -1154.83), new  Account("100100005v", 10005, 58785))
        println("Question 4.1\n")
        
        val overdraftList = overdraft(bank);
        overdraftList.foreach(a => println("     "+a.accNo+" balance : "+a.balance))
        println();

        println("Question 4.2\n")
        println("Sum of all account balances : "+sum(bank)+"\n")
        println("Question 4.3\n")
        println("Final balances of all accounts after apply the interest : ")
        val balancesList = interest(bank)
        balancesList.foreach(b => print(b+"\t"))
        println()
    }

    def overdraft(accounts: List[Account]): List[Account] = accounts.filter(acc => acc.balance<0)
    def sum(accounts: List[Account]): Double = accounts.foldLeft(0d)((total,a) => (a.balance + total))
    def interest(accounts: List[Account]): List[Double] = accounts.map(x => if(x.balance >=0) x.balance*1.05 else x.balance*1.1)
}