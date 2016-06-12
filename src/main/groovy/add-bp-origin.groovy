
import org.paic.d.D
List ll = []
new File("H:/script/bp-origin.txt").eachLine { line ->
	ll << line.split(/\t/)
}

def d = D.gen()
ll.each {one ->
	Map m = d.queryMap("select id, proj_name, status, verify_status from ih_bp_v2_detail where proj_name like '%${one[0]}%' and status=200 and verify_status=20000")
	if(m) {
		// println m
		Map r = [:]
		r.id = m.id
		r.origin = getOriginType(one[1])
		r.originRemark = one[2]
		println r
		d.update(r, 'ih_bp_v2_detail')
		println 'update ok'
	} else
		println 'not find'
}


def getOriginType(String des) {
	 String origin
        switch (des) {
            case '����ƽ̨����' :
                origin = '1'
                break
            case '������������' :
                origin = '2'
                break
            case '�����Ƽ�' :
                origin = '3'
                break
            case '΢��Ⱥ/ͼ��' :
                origin = '4'
                break
            case '����Ա������' :
                origin = '5'
                break
            case '��ҵ����' :
                origin = '6'
                break
            case '΢�Ź��ں�' :
                origin = '7'
                break
            case '����' :
                origin = '8'
                break
			case '�ؼ�������' :
				origin = '2'
				break
			case '�й��ô�ҵ' :
				origin = '7'
				break
		
            default:
                origin = '9'
        }
        origin
}