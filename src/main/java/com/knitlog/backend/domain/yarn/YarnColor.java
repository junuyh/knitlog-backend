package com.knitlog.backend.domain.yarn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class YarnColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)    /* YarnInfo를 즉시 같이 가져오지 않고, 실제로 필요할 때 가져오겠다, optional = false는 JPA 모델 관점에서 이 연관관계는 필수 */
    @JoinColumn(name = "yarn_info_id", nullable = false)    /* nullable = false는 DB 컬럼 관점에서 NULL을 허용하지 않는다 */
    private YarnInfo yarnInfo;

    private String colorCode;
    private String colorName;
    private String memo;


    public YarnColor(YarnInfo yarnInfo, String colorCode, String colorName, String memo) {
        this.yarnInfo = yarnInfo;
        this.colorCode = colorCode;
        this.colorName = colorName;
        this.memo = memo;
    }

    public void update(String colorCode, String colorName, String memo) {
        this.colorCode = colorCode;
        this.colorName = colorName;
        this.memo = memo;
    }
}
