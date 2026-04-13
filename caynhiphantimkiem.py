class Nut:
    def __init__(self,khoa=None):
        self.khoa = khoa
        self.trai = None
        self.phai = None
        
    def chen(self,khoa):
        if self is None:
            nut = Nut(khoa)
            self = nut
            return 
        
class CayNhiPhanTimKiem:
    def __init__(self,khoa=None):
        if khoa == None:
            self.goc = None
        else:
            self.goc = Nut(khoa)
            
    def chen(self, khoa):
        if self.goc is None:
            self.goc = Nut(khoa)
        else:
            self._chen_node(self.goc, khoa)

    def _chen_node(self, nut, khoa):
        if khoa < nut.khoa:
            if nut.trai is None:
                nut.trai = Nut(khoa)
            else:
                self._chen_node(nut.trai, khoa)
        elif khoa > nut.khoa:
            if nut.phai is None:
                nut.phai = Nut(khoa)
            else:
                self._chen_node(nut.phai, khoa)
        else:
            print(f'Bị trùng khoá {khoa}')

    def duyet_trai_nut_phai(self, goc=0):
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc

        if nut_ht == None:
            return []
        else: 
            kq = []
            kq_trai = self.duyet_trai_nut_phai(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            kq.append(nut_ht.khoa)
            kq_phai = self.duyet_trai_nut_phai(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            return kq

    def duyet_nut_trai_phai(self, goc=None):
        if goc is None:
            goc = self.goc
            if goc is None:
                return []

        if goc is None:
            return []

        kq = [goc.khoa]

        if goc.trai is not None:
            kq += self.duyet_nut_trai_phai(goc.trai)

        if goc.phai is not None:
            kq += self.duyet_nut_trai_phai(goc.phai)

        return kq
    
    def duyet_trai_phai_nut(self, goc=None):
        if goc is None:
            goc = self.goc
        if goc is None:
            return []

        kq = []

        if goc.trai is not None:
            kq += self.duyet_trai_phai_nut(goc.trai)

        if goc.phai is not None:
            kq += self.duyet_trai_phai_nut(goc.phai)

        kq.append(goc.khoa)

        return kq
    
def main():
        SO_PHAN_TU = 10
        cay = CayNhiPhanTimKiem()
        print("******Chèn vào cây**********")
        tap_gia_tri = set()
        from random import randint
        while len(tap_gia_tri) < SO_PHAN_TU:
            gt = randint(1,100)  #lấy 10 phần tử không trùng nhau nên dùng tập hợp
            tap_gia_tri.add(gt)
    #while

        tap_gia_tri = list(tap_gia_tri)  #Phát sinh danh sách ngẫu nhiên
    #tap_gia_tri = [66,46,84,11,81, 99,36,77,83, 87,100, 86, 85]
        print("Chèn lần lượt:", tap_gia_tri)
        for x in tap_gia_tri:
            cay.chen(x)

        kq = cay.duyet_trai_nut_phai()
        print("*******Duyệt cây theo Trái - Nút - Phải (LNR):", kq)
        print("NLR (Nút-Trái-Phải):", cay.duyet_nut_trai_phai())
        print("LRN (Trái-Phải-Nút):", cay.duyet_trai_phai_nut())
        
    
if __name__ == "__main__":
    main()