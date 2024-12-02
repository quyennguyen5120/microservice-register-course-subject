# Giới thiệu

---
Dự án mang tính thử nghiệm được xây dựng để giải quyết bài toán "nghẽn cổ chai" khi đăng ký học của các trường đại học tại Việt Nam.

# Kiến trúc nghiệp vụ (Business Architecture)

---
Dự án được chia thành ba module chính, mỗi module chịu trách nhiệm cho một phần nghiệp vụ quan trọng trong hệ thống:
### 1. **Xác thực người dùng**
Module này đảm nhận việc xác thực và bảo mật thông tin người dùng trong hệ thống. Các chức năng chính của module bao gồm:
- Đăng nhập và tạo tài khoản.
- Quản lý phiên làm việc và bảo mật thông tin.
- Kiểm tra quyền truy cập của người dùng.

Hệ thống sử dụng các cơ chế bảo mật như:
- Mã hóa mật khẩu một chiều.
- Xác thực qua token JWT.
- Kiểm tra vai trò người dùng để đảm bảo chỉ có thể truy cập các tính năng phù hợp với quyền hạn của họ.

### 2. **Đăng ký học**
Module này quản lý toàn bộ quy trình đăng ký học của sinh viên, bao gồm:
- Chọn khóa học và kiểm tra điều kiện đăng ký.
- Lưu trữ và quản lý thông tin đăng ký học của sinh viên.

Các tính năng nổi bật:
- Sinh viên có thể tìm kiếm các khóa học và đăng ký theo nhu cầu.
- Theo dõi tình trạng đăng ký học và thông báo về tình hình lớp học.
- Quản lý số lượng sinh viên tối đa trong lớp học và các yêu cầu đặc biệt khác trong quá trình đăng ký.

### 3. **Học phí**
Module này chịu trách nhiệm quản lý học phí của sinh viên, bao gồm:
- Tính toán học phí dựa trên các khóa học đã đăng ký.
- Xử lý thanh toán và theo dõi lịch sử thanh toán học phí.

Các chức năng hỗ trợ:
- Cấp hóa đơn học phí và gửi thông báo nhắc nhở thanh toán.
- Quản lý các khoản miễn giảm hoặc hỗ trợ tài chính cho sinh viên.
- Tích hợp với các cổng thanh toán trực tuyến để xử lý giao dịch học phí tự động.

Dự án giúp cải thiện quy trình đăng ký học và thanh toán học phí tại các trường đại học, mang lại trải nghiệm mượt mà và hiệu quả cho sinh viên.

# Kiến trúc Kỹ thuật (Technical Architecture)

---

# Hướng dẫn cài đặt

---

