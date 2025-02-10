package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private volatile int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override // synchronized <-- 한번에 하나의 스레드만 접근 가능
    public boolean withdraw(int amount) {

        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금액 보다 적으면, 진행하면 안됨

        synchronized (this) {
            // 임계 영역
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance -= amount;

            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
            // 임계 영역
        }

        // 잔고가 출금액 보다 많으면, 진행
        log("거래 종료");

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
