package com.java.can.pro;

/**
 * 新的Can 协议信息定义类
 */
public class Can2Protocol {

    public static final short HEADER = 0X550E;

    /* 这里用int 是避免因为用short 导致的溢出错误，因为运算过程还是转化为int 进行运算的 */

    // 获取版本 指令 0X41N
    public static final int GET_VERSION = 0X4A0;

    // 获取版本 应答 0X4AN
    public static final int FBK_GET_VER = 0X4A0;

    // 开始升级 指令 0X01N
    public static final int START_UPDATE = 0X0A0;

    // 开始升级 应答 0X0AN
    public static final int FBK_UPDATE = 0X0A0;

    // 写入 指令 范围是0x020 - 0x 02F
    public static final int WRITE_DATA = 0X0b0;

    // 写入 应答 范围是0x0BN - 0X0BF
    public static final int FBK_WRITE = 0X0b0;

    // 发送版本 指令
    public static final int SEND_VERSION = 0X4b0;

    // 发送版本 应答
    public static final int FBK_SEND_VERSION = 0X4B0;

    // 运动控制
    public static final int MOTION_CTRL = 0X110;

    // 灯光控制
    public static final int LIGHT_CTRL = 0X120;

    // 驻车控制
    public static final int PARK_CTRL = 0X130;

    // 设置节点ID
    public static final int SET_ND_ID = 0X4c0;

    // 反馈设置节点ID
    public static final int FBK_SET_ND_ID = 0x4c0;

    // 设置控制模式
    public static final int SET_CTRL_MODE = 0X420;

    // 配置转向零点
    public static final int SET_STEER_ZERO = 0X431;

    // 配置转向零点 反馈
    public static final int FBK_STEER_ZERO = 0X43a;

    // 四轮四转配转向零点
    public static final int FBK_RM_STEER_ZERO = 0X43b;

    // 四轮四转设置转向零点
    public static final int SET_RM_STEER_ZERO = 0X432;

    // 查询四轮四转转向零点
    public static final int GET_RM_STEER_ZERO = 0X433;

    // 状态置位
    public static final int RESET_ERR_INFO = 0X441;


    // 系统状态反馈
    public static final int FBK_SYS_STATUS = 0X210;
    public static final int FBK_MOT_STATUS = 0X220;
    public static final int FBK_LIGHT = 0X230;
    public static final int FBK_REMOTER = 0X240;
    public static final int FBK_H_DRV = 0X250;
    public static final int FBK_L_DRV = 0X260;
    public static final int FBK_FRONT_ODOM = 0X311;
    public static final int FBK_BACK_ODOM = 0X312;
    public static final int FBK_BMS = 0X360;
    public static final int FBK_BMS_VAL = 0X361;
    public static final int FBK_BMS_STATUS = 0X362;


    // 版本长度
    public static final int VERSION_SIZE = 80;

    // 写入数据的数据包大小
    public static final int PK_SIZE = 1024;

    // 一帧数据的有效 payload 长度
    public static final int PAYLOAD_SIZE = 8;

    // 节点范围 1-F
    public static final int MIN_ID = 0x0;
    public static final int MAX_ID = 0xf;

    /* ========== 开始升级应答的反馈帧含义 ================ */
    // APP 跳转 BootLoader;
    public static final byte APP_2_BOOT = 0X01;
    // 擦除FLASH
    public static final byte ERASE_FLASH = 0X02;
    // 擦除成功
    public static final byte ERASE_OK = 0x03;
    // 擦除失败
    public static final byte ERASE_FAIL = 0x04;

    /* =================== 写入数据应答的反馈帧含义 =============== */
    // 接收到固件数据
    public static final byte REC_DATA = 0x01;

    // 接收到1K数据，CRC校验成功，开始写入
    public static final byte CRC_OK = 0x02;

    // 接收到1K数据，CRC校验失败，需要重传
    public static final byte CRC_FAIL = 0X03;
    // 写入1K 数据成功
    public static final byte WRITE_OK = 0X04;

    // 写入1K 数据失败
    public static final byte WRITE_FAIL = 0x05;

    // 固件传输成功
    public static final byte FW_OK = 0X06;

    /* ================== 写入版本的应答 ====================*/

    // 写入版本成功
    public static final byte SEND_VER_OK = 0X00;
    // 写入版本失败
    public static final byte SEND_VER_FAIL = 0X01;
    // 类型：写入指令
    public static final byte SD_VER_TP = 0x0b;
    // 类型： 设置节点
    public static final byte SET_ND_TP = 0x0c;


    // 反馈转向零点队列
    public static final String STEER_ZERO_CHL = "STEER_ZERO_CHL";

    // 反馈设置节点队列
    public static final String SET_ND_CHL = "SET_ND_CHL";

    // 版本信息反馈队列
    public static final String FBK_VER_CHL = "FBK_VER_CHL";

    // 设置版本反馈队列
    public static final String FBK_SET_VER_CHL = "FBK_SET_VER_CHL";
    // 四轮四转转向零点反馈
    public static final String FBK_GET_RM_STEER_CHL = "FBK_GET_RM_STEER_CHL";
    // 开始升级指令的反馈信道
    public static final String FBK_START_UPGRADE_CHL = "FBK_START_UPGRADE_CHL";
    // 写入数据 反馈信道
    public static final String FBK_WRITE_DATA_CHL = "FBK_WRITE_DATA_CHL";


}
