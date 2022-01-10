package com.left.strategy;

/**
 * 策略模式
 * 定义算法族，分别封装起来，让它们之间可以相互替换
 */
public class Strategy {

    public static void main(String[] args) {
        Zombie zombie = new NormalZombie();
        zombie.display();
        zombie.move();
        zombie.attack();
        zombie.setMoveAble(new JumpMove());
        zombie.move();
    }

}

interface MoveAble {
    void move();
}
interface AttackAble {
    void attack();
}
class StepByStepMove implements MoveAble {

    @Override
    public void move() {
        System.out.println("step by step");
    }

}
class JumpMove implements MoveAble {

    @Override
    public void move() {
        System.out.println("jump");
    }

}
class BiteAttack implements AttackAble {

    @Override
    public void attack() {
        System.out.println("bite");
    }

}

abstract class Zombie {
    MoveAble moveAble;
    AttackAble attackAble;

    abstract public void display();
    abstract public void move();
    abstract public void attack();

    public MoveAble getMoveAble() {
        return moveAble;
    }

    public void setMoveAble(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    public AttackAble getAttackAble() {
        return attackAble;
    }

    public void setAttackAble(AttackAble attackAble) {
        this.attackAble = attackAble;
    }

}
class NormalZombie extends Zombie {

    public NormalZombie() {
        this.moveAble = new StepByStepMove();
        this.attackAble = new BiteAttack();
    }

    public NormalZombie(MoveAble moveAble, AttackAble attackAble) {
        this.moveAble = moveAble;
        this.attackAble = attackAble;
    }

    @Override
    public void display() {
        System.out.println("normal zombie");
    }

    @Override
    public void move() {
        moveAble.move();
    }

    @Override
    public void attack() {
        attackAble.attack();
    }
}
