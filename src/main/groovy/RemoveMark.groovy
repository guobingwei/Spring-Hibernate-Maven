


def sso = /����Groovy������ʽ0-9��[]��������';���˱�����/
def matcher = sso =~ /['������������!;\]\[]/  //���Լ����κ���Ҫ���˵������ַ���ע���е���Ҫת�壩
def newS = matcher.replaceAll('')
println newS