package launcher.Utility;

import client.Character.MapleCharacter;
import java.util.HashMap;
import java.util.Map;

import constants.ServerConstants;
import launcher.ServerPortInitialize.CashShopServer;
import launcher.ServerPortInitialize.ChannelServer;
import launcher.Utility.MapleHolders.MapleLocalisation;

public class WorldConnected {

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��������� ���� �ִ��� üũ.
     *
     * @param <int> ������ȣ
     *
     * @return ���������������
     *
     * @since Revision 25
     *
     */
    public static boolean hasMerchant(int accountId) {
        boolean ret = false;
        for (ChannelServer cserv : ChannelServer.getAllInstances()) {
            ret = cserv.constainsMerchant(accountId);
        }
        return ret;

    }

    /**
     * �� ä���� ����� ������ ���������� ���� ����
     *
     * @return ��ä���� ���� ������
     *
     * @since Revision 25
     *
     */
    public static Map<Integer, Integer> getConnected(int serverId) {
        Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
        int total = 0;
        for (int i = 0; i < ServerConstants.ChannelCount; i++) {
            int curConnected = ChannelServer.getInstance(i).getPlayerStorage().getConnectedClients();
            ret.put(i, curConnected);
            total += curConnected;
        }
        ret.put(0, total);
        return ret;
    }

    public static int getConnectedi() {
        int total = 0;
        for (int i = 0; i < ServerConstants.ChannelCount; i++) {
            int curConnected = ChannelServer.getInstance(i).getPlayerStorage().getConnectedClients();
            total += curConnected;
        }
        return total;
    }

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��� ä�ο� ������ �ִ��� Ȯ��.
     *
     * @param <String> ������
     *
     * @return ������ ä�� (�����ӽ� -1 ��ȯ)
     *
     * @since Revision 25
     *
     */
    public static int find(String charName) {
        for (ChannelServer cserv : ChannelServer.getAllInstances()) {
            if (cserv.getPlayerStorage().getCharacterByName(charName) != null) {
                return cserv.getChannel();
            }
        }
        return -1;
    }

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��� ä�ο� ������ �ִ��� Ȯ��.
     *
     * @param <int> �����ѹ�
     *
     * @return ������ ä�� (�����ӽ� -1 ��ȯ)
     *
     * @since Revision 25
     *
     */
    public static int find(int characterId) {
        for (ChannelServer cserv : ChannelServer.getAllInstances()) {
            if (cserv.getPlayerStorage().getCharacterById(characterId) != null) {
                return cserv.getChannel();
            }
        }
        return -1;
    }

    /**
     * ĳ�ü� ä���� ��ĵ�Ͽ� �ش� ������ ĳ�ü��� ������ �ִ��� Ȯ��.
     *
     * @param <String> ������
     *
     * @return ĳ�ü����ӿ���
     *
     * @since Revision 25
     *
     */
    public static boolean isCharacterInCS(String name) {
        return CashShopServer.getInstance().getPlayerStorage().isCharacterConnected(name);
    }

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��� ä�ο��� ������ �ִ��� Ȯ��.
     *
     * @param <String> ������
     *
     * @return ���ӿ���
     *
     * @since Revision 25
     *
     */
    public static boolean isConnected(String charName) {
        for (ChannelServer cserv : ChannelServer.getAllInstances()) {
            if (cserv.getPlayerStorage().getCharacterByName(charName) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��� ä�ο��� ������ �ִ��� Ȯ��.
     *
     * @param <int> �����ѹ�
     *
     * @return ���ӿ���
     *
     * @since Revision 25
     *
     */
    public static boolean isConnected(int id) {
        for (ChannelServer cserv : ChannelServer.getAllInstances()) {
            if (cserv.getPlayerStorage().getCharacterById(id) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * ��� ä���� ��ĵ�Ͽ� �ش� ������ ��ġ������ ����.
     *
     * @param <String> ������
     *
     * @return �ش������� ��ġ����
     *
     * @since Revision 25
     *
     */
    public static MapleLocalisation getLocation(String charName) {
        int channel = WorldConnected.find(charName);
        if (channel != -1) {
            MapleCharacter chr = ChannelServer.getInstance(channel).getPlayerStorage().getCharacterByName(charName);
            if (chr != null) {
                return new MapleLocalisation(chr.getMapId(), (byte) channel);
            }
        }
        return null;
    }

    public static Map<Integer, Integer> getConnected() {
        Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
        int total = 0;
        for (int i = 0; i < ServerConstants.ChannelCount; i++) {
            int curConnected = ChannelServer.getInstance(i).getPlayerStorage().getConnectedClients();
            ret.put(i, curConnected);
            total += curConnected;
        }
        ret.put(0, total);
        return ret;
    }
}