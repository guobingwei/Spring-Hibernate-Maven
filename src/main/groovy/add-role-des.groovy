
import org.paic.d.D

def addRole = {
	List roleList = ['��ʹ��', 'Pre-A��', 'A��', 'B��', 'C��']
	def d = D.gen()

	for(int i = 0; i < roleList.size(); i++) {
            Map r = [:]
            r.tagId = 2 ** i
            r.tagDes = roleList.get(i)
	    r.type = 5
            d.add(r, 'ih_bp_v2_tag')
    }
}

addRole()