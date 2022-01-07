import Btn from "components/atoms/Btn";
import * as S from "./style";
import { NAV_BAR_LOGOUT, NAV_BAR_LOGIN, NAV_BAR_SIGN_UP, NAV_BAR_SETTING } from "common/constants/string";

export default function NavBarButton({ contents }) {
    return (
        <S.NavButtonContainer>
            {contents.map((content) => (
                <S.NavButton>{content}</S.NavButton>
            ))}
        </S.NavButtonContainer>
    );
}
