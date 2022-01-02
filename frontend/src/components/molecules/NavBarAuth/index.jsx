import Btn from "components/atoms/Btn";
import * as S from "./style";
import { NAV_BAR_LOGOUT, NAV_BAR_LOGIN, NAV_BAR_SIGN_UP, NAV_BAR_SETTING } from "common/constants/string";

export default function NavBarAuth({ isLogin }) {
    if (isLogin) {
        return (
            <S.LoginContainer>
                <Btn>{NAV_BAR_LOGOUT}</Btn>
                <Btn>{NAV_BAR_SETTING}</Btn>
            </S.LoginContainer>
        );
    }

    return (
        <S.LoginContainer>
            <Btn children={"NAV_BAR_LOGIN"}>{NAV_BAR_LOGIN}</Btn>
            <Btn>{NAV_BAR_SIGN_UP}</Btn>
        </S.LoginContainer>
    );
}
