public class B4 {
    public static void main(String[] args) {
        // Chuỗi ban đầu có độ dài lớn để kiểm tra hiệu suất
        String initialString = "abcdefghij".repeat(100000);

        // ================== STRINGBUILDER ==================
        // StringBuilder KHÔNG đồng bộ => Hiệu suất cao hơn trong môi trường đơn luồng
        System.out.println("=== StringBuilder Performance ===");
        StringBuilder sb = new StringBuilder(initialString);

        long startTime = System.nanoTime();
        sb.reverse(); // Đảo ngược chuỗi
        long endTime = System.nanoTime();
        System.out.println("Reverse Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sb.insert(500000, "insert_string"); // Chèn chuỗi tại vị trí 500000
        endTime = System.nanoTime();
        System.out.println("Insert Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sb.delete(250000, 350000); // Xóa các ký tự từ 250000 đến 350000
        endTime = System.nanoTime();
        System.out.println("Delete Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sb.replace(100000, 200000, "replace_string"); // Thay thế chuỗi từ 100000 đến 200000
        endTime = System.nanoTime();
        System.out.println("Replace Time: " + (endTime - startTime) + " ns");

        // ================== STRINGBUFFER ==================
        // StringBuffer có cơ chế đồng bộ hóa => An toàn hơn trong môi trường đa luồng nhưng chậm hơn
        System.out.println("\n=== StringBuffer Performance ===");
        StringBuffer sf = new StringBuffer(initialString);

        startTime = System.nanoTime();
        sf.reverse();
        endTime = System.nanoTime();
        System.out.println("Reverse Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sf.insert(500000, "insert_string");
        endTime = System.nanoTime();
        System.out.println("Insert Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sf.delete(250000, 350000);
        endTime = System.nanoTime();
        System.out.println("Delete Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        sf.replace(100000, 200000, "replace_string");
        endTime = System.nanoTime();
        System.out.println("Replace Time: " + (endTime - startTime) + " ns");

        // ================== KẾT LUẬN ==================
        /*
         *  StringBuilder:
         *   - Không đồng bộ (Not Thread-safe) -> Hiệu suất cao hơn khi chạy đơn luồng
         *   - Thích hợp cho xử lý chuỗi lớn trong ứng dụng không cần đa luồng
         *
         *  StringBuffer:
         *   - Đồng bộ (Thread-safe) -> An toàn hơn nhưng chậm hơn
         *   - Dùng trong môi trường đa luồng để tránh xung đột dữ liệu
         *
         *  Khi cần tốc độ -> Dùng StringBuilder
         *  Khi cần an toàn trong đa luồng -> Dùng StringBuffer
         */
    }
}
