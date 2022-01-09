package com.left.factory;

/**
 * 抽象工厂模式
 * 提供一个创建一系列相互或相互依赖对象的接口，而无需指定它们具体的类
 */
public class AbstractFactory {

    public static void main(String[] args) {

        IDatabaseUtils iDatabaseUtils = new OracleDatabaseUtils();
        IConnection connect = iDatabaseUtils.getConnect();
        connect.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();

    }

}

/**
 * 基础规范
 */
interface IConnection {
    void connect();
}
interface ICommand {
    void command();
}
interface IDatabaseUtils {
    IConnection getConnect();
    ICommand getCommand();
}

/**
 * mysql
 */
class MysqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("mysql connection");
    }

}
class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql command");

    }
}
class MysqlDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnect() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }

}

/**
 * oracle
 */
class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("oracle connect");
    }

}
class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("oracle command");
    }

}
class OracleDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnect() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}