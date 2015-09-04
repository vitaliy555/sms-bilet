package com.springapp.mvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class PSVM {
    public static void main(String[] args) {
        String s = new String(
                "[ \"������ (��������)~21073\", \"������ (�������� ���������)~24830\", \"����� (��������)~34545\", \"����� �������� (������)~22393\", \"������ (������)~47144\", \"�������� (������)~47189\", \"������ (��������)~21202\", \"�������� (������)~22394\", \"���� ��� (������)~3980\", \"������� (������)~49946\", \"�������� (������)~23612\", \"��������� (������)~49671\", \"��.�.1553 �� (������)~205\", \"��.�.263 �� (������)~270\", \"��������� ̳��� (��������)~21040,21113\", \"����� (������)~2252\", \"������� (�������� ���������)~20160,20420\", \"�������� (�������� ���������)~24942\", \"��������� (������)~22637\", \"������ (������)~22397\", \"�'����� (������)~47274\", \"³���� (������)~22122\", \"������� ̳��� (������)~2190,2191,2189\", \"���������� (��������)~21245\", \"�������� (������)~49519\", \"��������� (������)~34700\", \"�������� (������)~22078\", \"������� (��������)~21081\", \"����������� (������)~22543\", \"������ ĳ������ (������)~47187\", \"�������� (������)~49881\", \"������(���.44��) (������)~372\", \"��������� (������)~47271\", \"�������� (������)~810\", \"��������� (������)~22392\", \"������ (��������)~21077\", \"����� (������)~22544\", \"������ (������)~22636\", \"��������� (������)~49883\", \"��������� (������)~22658\", \"��������� (�������� ���������)~1302\", \"������ (������)~49884\", \"������� (������)~23419\", \"������� (������)~49645\", \"�������� (��������)~21198\", \"�������� (��������)~34526\", \"���� ��� (������)~49845\", \"������ (������)~47269\", \"����� (���������)~25968\", \"������� (������)~22399\", \"���� (������)~3403\", \"���'���� (������)~49390\", \"������ (������)~22322\", \"������ (��������)~21203\", \"���������� (������)~49802\", \"�������� (������)~22269\", \"�������� (������)~47272\", \"��������������� (������)~22700,22701\", \"����� (��������)~21079\", \"������ (������)~47168\", \"����� (������)~47186\", \"�������� (�������� ���������)~24537\", \"���������� (������)~49958\", \"������� (������)~841\", \"�.�.102 �� (������)~49759\", \"�.�.120 �� (������)~49998\", \"�.�.13 �� (������)~3419\", \"�.�.132 �� (������)~35106\", \"�.�.141 �� (������)~49853\", \"�.�.146 �� (������)~49949\", \"�.�.146 �� (������)~49809\", \"�.�.15 �� (������)~487\", \"�.�.161 �� (������)~3188\", \"�.�.168 �� (������)~49874\", \"�.�.185 �� (������)~22642\", \"�.�.198 �� (������)~49659\", \"�.�.24 �� (������)~3436\", \"�.�.25 �� (������)~22444\", \"�.�.29 �� (������)~3423\", \"�.�.33 �� (������)~3420\", \"�.�.40 �� (������)~49876\", \"�.�.40 �� (������)~20955\", \"�.�.52 �� (������)~476\", \"�.�.52 �� (������)~799\", \"�.�.59 �� (������)~3418\", \"�.�.67 �� (������)~3378\", \"�.�.70 �� (������)~22640\", \"�.�.72 �� (������)~49851\", \"�.�.79 �� (������)~49627\", \"�.�.86 �� (������)~3417\", \"�.�.9 �� (������)~20953\", \"�.�.9 �� (������)~479\", \"������ 2 (�����������)~48913\", \"������� (������)~49989\", \"����������. (������)~47183\", \"������ (������)~761\", \"�������� (������)~22730,22800\", \"������� (������)~3706\", \"������ (������)~49438\", \"�������� (������)~47262\", \"������������ (������)~22501\", \"��������� (������)~22197,22198\", \"���'����-������ (������)~23071\", \"����-���� (���������)~28891\", \"��������� (������)~47184\", \"����������� (������)~3308\", \"������� (������)~47415\", \"��� ̳��� (������)~739,47125,22080,47140,47175,22298,47255,22000,47190,3723\", \"������� (������)~34720\", \"�������� (������)~23533\", \"�������� (������)~22511\", \"����.������ (������)~47226\", \"���������� (������)~20954\", \"������� (������)~49833\", \"�������� (������)~811\", \"������ 2455 �� � (�����������)~8840\", \"��������� (������)~809\", \"��������� ̳��� (������)~22098,22110\", \"��������� (������)~22502\", \"������� (���������)~28893\", \"����� (������)~2157,2305\", \"��������� (����������)~2332\", \"���������� (������)~22503\", \"������ г�-̳��� (������)~22680,22900,22840,22747\", \"������� (������)~22271\", \"���'����� ̳��� (������)~22380,49940,22403\", \"����� (������)~22533\", \"˳������� (������)~22641\", \"��������������� (������)~49242\", \"����������� (������)~49950\", \"��������� (������)~34725\", \"����� (��������)~21287\", \"��������� (������)~47278\", \"������� (������)~22309\", \"���� ̳��� (������)~47548,23092,23081,23215,36921,23200\", \"�������� (�������� ���������)~45615\", \"������� (������)~49790\", \"̳���� (��������)~21000,21001\", \"̳������ (������)~3111\", \"̳������ (����������)~2329\", \"���� ������� (������)~47188\", \"�������� (������)~49795\", \"������ (������)~34736\", \"������ (������)~34737\", \"������� (������)~23540,23536\", \"����������� (������)~22401\", \"������ (�������� ���������)~20001,20007\", \"�������� (������)~22079\", \"����� (��������)~21199\", \"��������� (������)~22068\", \"������ (��������)~21076\", \"���� ���� (������)~22262\", \"����������� (������)~371\", \"���������� (������)~49466\", \"����� (������)~23600,23629\", \"����� (������)~49944\", \"������������ (������)~49632\", \"���������� (�������� ���������)~24941\", \"�������� (������)~49855\", \"������ (������)~20956\", \"������� (������)~49890\", \"�'������� (������)~49676\", \"ϳ�������� (������)~22638\", \"�������-1 (������)~49376\", \"�������-2 (������)~3161\", \"����������� (������)~22538\", \"������� (������)~47151\", \"������� (�����������)~35853\", \"��.226 �� (������)~3187\", \"������� (������)~22580,22590\", \"���� 159 �� (������)~49226\", \"���� 16 �� (�������� ���������)~10207\", \"���� 230 �� (������)~362\", \"���� 391 �� (�������� ���������)~15804\", \"���� 48 �� (������)~49299\", \"����������.���� (������)~445\", \"�������� (������)~47246\", \"������ (��������)~34569\", \"���������� (������)~22395\", \"��������� (������)~49679\", \"��������� (������)~49896\", \"�������� (������)~36177\", \"г��� (������)~49928\", \"������� (������)~47162\", \"������ (������)~34790\", \"���������� (��������)~6549\", \"������ (��������)~34653\", \"�������� (������)~2297\", \"������ (��������)~21195\", \"�������� (������)~22396\", \"���������� (����������)~8770\", \"������ (������)~36181\", \"������� (������)~49844\", \"ѳ������� (��������)~21204\", \"������� (�����������)~48915\", \"������ (������)~49718\", \"�����-���������-�-�� (�������� ���������)~10206\", \"��������� (�������� ���������)~24820\", \"������ (������)~49726\", \"������������ (������)~3722\", \"������� (������)~49635\", \"������� �� (������)~49719\", \"������������ (������)~22920,22940\", \"������ (������)~22402\", \"����� (������)~34764\", \"�������������� (������)~22521\", \"��������� (������)~49822\", \"���������� (������)~22026\", \"������� (������)~3344\", \"��������� (������)~34768\", \"������ (������)~49808\", \"�������� (�������� ���������)~20360,20370\", \"������ (���������)~25965\", \"��������� (������)~36186\", \"��������� (������)~36210\", \"�������� (�������� ���������)~24950\", \"��������� (������)~22077\", \"����� (������)~22100,22446,22410\", \"������ (��������)~8372\", \"��������� (��������)~34570\", \"���������� (������)~8014\", \"������� (������)~3109\", \"������� (��������)~21166\", \"������� (������)~49811\", \"����� (������)~3186\", \"�������� (������)~22076\", \"�������� (������)~22398\", \"������ (����������)~2330\", \"������� (������)~785\", \"������� (������)~22618\", \"������� (��������)~34568\", \"���������� (�������� ���������)~24947\", \"����� (��������)~21167\", \"5-� ���� (������)~201\", \"���������� (������)~49517\", \"������� (��������)~21041\", \"������ (������)~23207\", \"������������ (�������� ���������)~24780\", \"���������� (������)~22875\", \"������ (��������)~21135\", \"�������� (�������� ���������)~45163\", \"���쳿��� (������)~23468\", \"������� (�������� ���������)~20227\", \"����� (�������� ���������)~24880\", \"����� (���������)~28920\", \"�������� (������)~23457\", \"������� (������)~23044\", \"�������� (������)~22172\", \"�����-������ (������)~23535\", \"�����-��������� (������)~23000\", \"�������� (������)~22187\", \"������ (������)~22679\", \"������ (������)~47156\", \"�������� (������)~22105\", \"������ (������)~22676\", \"�������� (�������� ���������)~25216\", \"����� (������)~23580\", \"����� (�������� ���������)~20506\", \"�������� (������)~22253\", \"���� (������)~22420\", \"������� (�������� ���������)~24519\", \"��������� (������)~22677\", \"������-1 (���������)~25820\", \"��.������ ������� (������)~22044\", \"��.������ ������ (������)~22506\", \"��.������ ʳ��� (������)~22065\", \"��.����� �������� (������)~22416\", \"��.������ �������� (������)~23350\", \"����� (������)~22083\", \"������� (���������)~28887\", \"���� (������)~22091\", \"������� (������)~23368\", \"���� (������)~22549\", \"������� (������)~22575\", \"���������� (������)~23439\", \"�������� (�������� ���������)~24527\", \"������������ (������)~22551\", \"������ (������)~23349\", \"������� (������)~22221\", \"������� (������)~23483\", \"����������� (�������� ���������)~24925\", \"����� (������)~23495\", \"������ (�������� ���������)~24892\", \"��������� (������)~22286\", \"�������� (�������� ���������)~20813\", \"����������� (���������)~28942\", \"������ (������)~22495\", \"���� (������)~550\", \"������� (�������� ���������)~24718\", \"���������� (������)~22539\", \"������� (�������� ���������)~24872\", \"��������� (������)~23120\", \"���������� (�������� ���������)~46046\", \"���������� (������)~22830\", \"�������� (�������� ���������)~45440\", \"������� (�������� ���������)~24730\", \"�������� (������)~47333\", \"�������� (������)~22767\", \"�������� (�������� ���������)~25116\", \"���������-2 (������)~24180\", \"����� (������)~23490\", \"������� (��������)~6501\", \"�������� (������)~24274\", \"������ (���������)~28500\", \"��������� (�������� ���������)~24600\", \"������� (���������)~28880\", \"�������� (�������� ���������)~24790\", \"����� (�������� ���������)~20523\", \"���� ������� (������)~23521\", \"���� ������ (������)~22180\", \"���� ���������� (������)~23156\", \"��������-������. (������)~23560\", \"����� (������)~47508\" ]");
        List<String> list = Splitter.on(CharMatcher.anyOf("\"[")).trimResults().splitToList(s);
        Set set = new HashSet();
        set.addAll(list);
        System.out.println(list.size());
        System.out.println(set.size());
        set.remove(",");
        System.out.println(set.size());
    }
}
