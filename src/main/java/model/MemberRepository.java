package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

public class MemberRepository extends Repository {
	private static byte[] sha256(String plaintext) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(plaintext.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
			return null;
		}
	}

	private static long random() {
		Random rand = new Random();
		long a = rand.nextInt();
		long b = rand.nextInt();
		return a * b;
	}

	public int add(Member obj) throws SQLException {
		try {
			open();
			pstmt = connection.prepareStatement(
					"INSERT INTO Member (MemberId, Username, Password, FullName, Email, Gender) VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setLong(1, random());
			pstmt.setString(2, obj.getUsername());
			pstmt.setBytes(3, sha256(obj.getPassword()));
			pstmt.setString(4, obj.getFullname());
			pstmt.setString(5, obj.getEmail());
			pstmt.setByte(6, obj.getGender());
			return pstmt.executeUpdate();
		} finally {
			close();
		}
	}
}
